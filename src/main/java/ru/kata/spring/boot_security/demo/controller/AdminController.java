package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(@ModelAttribute("user") User user,
                              Principal principal, Model model) {
        Long id = userService.findByUsername(principal.getName()).get().getId();
        model.addAttribute("admin", userService.getById(id));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getRoles());
        return "admin";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.getRoles());
        return "redirect:/admin";
    }
    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id") long id,
                           @ModelAttribute("user") User user){
        userService.edit(id, user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }
}
