package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kata.spring.boot_security.demo.model.User;

@Controller
public class LoginController {
    @GetMapping("/")
    public String loginRedirectPage() {
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }
}
