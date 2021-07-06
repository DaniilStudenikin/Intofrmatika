package ru.itis.di_example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.di_example.services.RandomNumbersService;

@Controller
public class RandomNumbersController {
    @Autowired
    @Qualifier("randomNumbersWithRangeService")
    private RandomNumbersService service;

    @GetMapping("/numbers")
    public String getNumbersPage(Model model) {
        model.addAttribute("randomNumber", service.random());
        return "numbers";
    }
}
