package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Offerta;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {

    @Autowired
    private OffertaRepository offertaRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("offerte", offertaRepository.findAll());
        return "offerte/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("offerta", new Offerta());
        model.addAttribute("pizze", pizzaRepository.findAll());
        return "offerte/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offerta") Offerta formOfferta, BindingResult bindingResult,
            @RequestParam("pizza") Integer pizzaId,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("pizze", pizzaRepository.findAll());
            return "offerte/create";
        }

        Pizza pizza = pizzaRepository.findById(pizzaId).orElse(null);
        if (pizza == null) {
            bindingResult.rejectValue("pizza", "error.pizza", "Pizza non valida");
            model.addAttribute("pizze", pizzaRepository.findAll());
            return "offerte/create";
        }

        formOfferta.setPizza(pizza);

        offertaRepository.save(formOfferta);
        return "redirect:/offerte";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        offertaRepository.deleteById(id);
        return "redirect:/pizze";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("offerta", offertaRepository.findById(id).get());
        model.addAttribute("pizze", pizzaRepository.findAll());
        return "offerte/edit";
    }

    @PostMapping("/{id}")
public String update(@PathVariable Integer id,
                     @Valid @ModelAttribute("offerta") Offerta offertaForm,
                     BindingResult bindingResult,
                     @RequestParam("pizza") Integer pizzaId,
                     Model model) {

    if (bindingResult.hasErrors()) {
        model.addAttribute("pizze", pizzaRepository.findAll());
        return "offerte/edit";
    }

    Pizza pizza = pizzaRepository.findById(pizzaId).orElse(null);
    if (pizza == null) {
        bindingResult.rejectValue("pizza", "error.pizza", "Pizza non valida");
        model.addAttribute("pizze", pizzaRepository.findAll());
        return "offerte/edit";
    }

    offertaForm.setPizza(pizza);

    offertaRepository.save(offertaForm);
    return "redirect:/pizze";
}

}
