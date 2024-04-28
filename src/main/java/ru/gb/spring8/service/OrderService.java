package ru.gb.spring8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring8.model.Orders;
import ru.gb.spring8.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Orders add(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    public Orders findById(Long reserveId) {
        return orderRepository.findById(reserveId).orElseThrow();
    }

    public void update(Orders reserveOrder) {
        orderRepository.save(reserveOrder);
    }
}
