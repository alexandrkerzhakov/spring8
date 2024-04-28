package ru.gb.spring8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring8.model.Product;
import ru.gb.spring8.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/all")
    public List<Product> findByAll() {
        return productService.findAll();
    }
}
