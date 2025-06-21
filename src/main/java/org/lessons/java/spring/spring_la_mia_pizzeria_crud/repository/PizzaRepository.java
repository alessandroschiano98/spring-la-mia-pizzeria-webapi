package org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    List<Pizza> findByNomeContainingIgnoreCase(String nome);

    List<Pizza> findByDescrizioneContainingIgnoreCase(String descrizione);

}


