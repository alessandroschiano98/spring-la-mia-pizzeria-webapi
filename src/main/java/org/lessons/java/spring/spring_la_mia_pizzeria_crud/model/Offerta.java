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
@Table(name = "offerte")
public class Offerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate offertaAddDate;

    private LocalDate offertaRemoveDate;

    private String titolo;


    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDate getOffertaAddDate() {
        return this.offertaAddDate;
    }

    public void setOffertaAddDate(LocalDate offertaAddDate) {
        this.offertaAddDate = offertaAddDate;
    }

    public LocalDate getOffertaRemoveDate() {
        return this.offertaRemoveDate;
    }

    public void setOffertaRemoveDate(LocalDate offertaRemoveDate) {
        this.offertaRemoveDate = offertaRemoveDate;
    } 

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }



}