package ru.gb.spring8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring8.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
