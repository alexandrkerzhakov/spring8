package ru.gb.spring8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring8.model.Director;
import ru.gb.spring8.repository.DirectorRepository;

import java.math.BigDecimal;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public Director findById(Long id) {
        return directorRepository.findById(id).orElseThrow();
    }

    public BigDecimal addProfit(BigDecimal productCosts, Long id) {
        Director director = findById(id);
        director.setProfit(director.getProfit().add(productCosts));
        directorRepository.save(director);
        return director.getProfit();
    }

    public Director add(Director director) {
        return directorRepository.save(director);
    }
}
