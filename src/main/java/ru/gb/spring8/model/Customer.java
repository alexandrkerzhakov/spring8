package ru.gb.spring8.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cash")
    private BigDecimal cash;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//    private List<Orders> orders = new ArrayList<>();
}
