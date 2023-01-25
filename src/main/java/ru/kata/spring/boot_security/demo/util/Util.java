package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Util {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Util(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");
        List<Role> adminList = new ArrayList<>();
        List<Role> userList = new ArrayList<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminList.add(roleAdmin);
        adminList.add(roleUser);
        userList.add(roleUser);

        User admin = new User("admin", "adminov", 20, "admin@gmail.com", "admin", adminList);
        admin.setId(1L);

        User user = new User("user", "userov", 22, "user@gmail.com", "user", userList);
        user.setId(2L);

        userService.save(admin);
        userService.save(user);
    }
}

