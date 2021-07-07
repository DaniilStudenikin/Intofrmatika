package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.services.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "users_page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/banAll")
    public String banUsers() {
        userService.banAll();
        return "redirect:/users";
    }
}
