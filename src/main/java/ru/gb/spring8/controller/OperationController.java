package ru.gb.spring8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring8.dto.PayDTO;
import ru.gb.spring8.dto.ReserveDTO;
import ru.gb.spring8.model.Orders;
import ru.gb.spring8.service.OperationService;

    @RestController
    @RequestMapping("/operation")
    public class OperationController {
        @Autowired
        OperationService operationService;


        /**
         * Операция резервирования продукта
         * @param reserveDTO
         * @return Orders
         */

        @PostMapping("/reserve")
        public Orders reserve(@RequestBody ReserveDTO reserveDTO) {
            return operationService.reserve(reserveDTO);
        }

        /**
         * Операция оплаты продукта
         * @param payDTO
         * @return Orders
         * @throws Exception
         */

        @PostMapping("/pay")
        public Orders pay(@RequestBody PayDTO payDTO) throws Exception {
            return operationService.pay(payDTO);
        }
}
