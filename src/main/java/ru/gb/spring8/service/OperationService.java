package ru.gb.spring8.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring8.aspect.Action;
import ru.gb.spring8.dto.PayDTO;
import ru.gb.spring8.dto.ReserveDTO;
import ru.gb.spring8.model.Customer;
import ru.gb.spring8.model.Orders;
import ru.gb.spring8.model.Product;
import ru.gb.spring8.model.Status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class OperationService {
    @Autowired
    OrderService orderService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    DirectorService directorService;

    /**
     * Метод для резервирования списка продуктов:
     * Поиск покупателя
     * Поиск продукта
     * Создание объекта Orders со статусом Status.RESERVE, его сохранение
     *
     * @param reserveDTO
     * @return Orders
     */
    @Action // отрабатывает для каждого метода, вызываемого внутри reserve
    public Orders reserve(ReserveDTO reserveDTO) {
        Customer customer = customerService.findById(reserveDTO.getCustomerId());
        Product product = productService.findById(reserveDTO.getProductId());
        List<Product> products = new ArrayList<>(List.of(product));

        Orders order = Orders.builder()
                .status(Status.RESERVE)
                .customer(customer)
                .product(products)
                .build();
        return orderService.add(order);
    }

    /**
     * Метод для оплаты продукта:
     * Поиск зарезервированного заказа
     * Определение стоимости заказа
     * Оплата заказа(смена статуза заказа на Status.PAY, увеличение прибыли директора, уменьшения суммы денег покупателя)
     * @param payDTO
     * @return Orders
     * @throws Exception
     */

    @Action // отрабатывает для каждого метода, вызываемого внутри pay
    public Orders pay(PayDTO payDTO) throws Exception {
        Orders reserveOrder = orderService.findById(payDTO.getReserveProductId());
        BigDecimal productCosts = reserveOrder
                .getProduct()
                .stream()
                .map(Product::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Customer customerPay = reserveOrder.getCustomer();
        if (customerPay.getCash().compareTo(productCosts) > 0) {
            reserveOrder.setStatus(Status.PAY);
            orderService.update(reserveOrder);
            directorService.addProfit(productCosts, payDTO.getDirectorId());
            customerService.subtractCost(productCosts, customerPay);
        } else {
            throw new Exception("Not enough money");
        }
        return reserveOrder;
    }
}
