package org.lessons.java.spring.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sconti")
public class Sconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate scontoAddDate;

    private LocalDate scontoRemoveDate;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getScontoAddDate() {
        return this.scontoAddDate;
    }

    public void setScontoAddDate(LocalDate scontoAddDate) {
        this.scontoAddDate = scontoAddDate;
    }

    public LocalDate getScontoRemoveDate() {
        return this.scontoRemoveDate;
    }

    public void setScontoRemoveDate(LocalDate scontoRemoveDate) {
        this.scontoRemoveDate = scontoRemoveDate;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

}