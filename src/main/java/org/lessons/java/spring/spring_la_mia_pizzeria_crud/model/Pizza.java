package org.lessons.java.spring.spring_la_mia_pizzeria_crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String descrizione;

    @Column(name = "foto_url", length = 255)
    private String fotoUrl;

    @Column(name = "prezzo", nullable = false)
    private Double prezzo;

    // ! COSTRUTTORI
    public Pizza() {}

    public Pizza(String nome, String descrizione, String fotoUrl, Double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.fotoUrl = fotoUrl;
        this.prezzo = prezzo;
    }

    // ! GETTER & SETTER
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString(){
        return this.nome;
    }


}
