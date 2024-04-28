package ru.gb.spring8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring8.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
