package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.services.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "users_page";
    }
}
