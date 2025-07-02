package org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Sconto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScontoRepository extends JpaRepository<Sconto, Integer> {
}
