package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizze = pizzaRepository.findAll(); // ! QUI PRENDERO' I DATI DAL DB
        model.addAttribute("pizze", pizze);// ! oppure model.addAttribute("pizze, pizzaRepository.findAll();")
        return "pizze/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        // ! Optional<Pizza> pizzaAttempt = pizzaRepository.findById(id);
        // ! Pizza pizza = pizzaAttempt.get();
        Pizza pizza = pizzaRepository.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "pizze/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizze/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "pizze/create";
        }

        pizzaRepository.save(formPizza);
        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pizza non trovata"));
        model.addAttribute("pizza", pizza);
        return "pizze/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
            @Valid @ModelAttribute("pizza") Pizza formPizza,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "pizze/edit";
        }

        formPizza.setId(id);
        pizzaRepository.save(formPizza);
        return "redirect:/pizze";
    }

}
