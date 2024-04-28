package ru.gb.spring8.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost", precision = 15, scale = 2)
    private BigDecimal cost;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    private List<Orders> orderList = new ArrayList<>();
}
