package ru.gb.spring8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring8.model.Customer;
import ru.gb.spring8.service.CustomerService;

import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerService.findByAll();
    }
}
