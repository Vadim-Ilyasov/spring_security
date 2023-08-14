package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class init {
    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public init(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void initUsers() {
        Role admin = new Role("ROLE_ADMIN");
        roleRepository.save(admin);
        Collection<Role> roles = new ArrayList<>();
        roles.add(admin);
        userService.saveUser(new User("Admin", "Adminov",
                23, "a@a.ru", roles, "Admin", "admin"));

        Role user = new Role("ROLE_USER");
        roleRepository.save(user);
        Collection<Role> users = new ArrayList<>();
        users.add(user);
        userService.saveUser(new User("User", "Us",
                22, "a@a.ru", users, "User", "user"));
    }
}
