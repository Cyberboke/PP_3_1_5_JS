package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findByEmail(String email);
    User getById(long id);
    void deleteById(long id);
    void save(User user);
    void edit(long id, User user);
}
