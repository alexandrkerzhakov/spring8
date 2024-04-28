package ru.gb.spring8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring8.model.Director;
import ru.gb.spring8.service.DirectorService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping("/add")
    public Director add(@RequestBody Director director) {
        return directorService.add(director);
    }

    @GetMapping("/profit/{id}")
    public BigDecimal getProfit(@PathVariable("id") Long id) {
        return directorService.findById(id).getProfit();
    }
}
