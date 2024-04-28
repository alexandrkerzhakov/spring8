package ru.gb.spring8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring8.aspect.Action;
import ru.gb.spring8.model.Customer;
import ru.gb.spring8.repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Action
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findByAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    public Customer subtractCost(BigDecimal productCosts, Customer customer) {
        customer.setCash(customer.getCash().subtract(productCosts));
        return customerRepository.save(customer);
    }
}
