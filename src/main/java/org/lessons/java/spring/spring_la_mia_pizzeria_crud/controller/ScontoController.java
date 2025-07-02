package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.ScontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sconti")
public class ScontoController {

    @Autowired
    private ScontoRepository scontoRepository;


    @GetMapping
    public String index(Model model){
        model.addAttribute("sconti", scontoRepository.findAll());
        return "sconti/index";
    }

    
}
