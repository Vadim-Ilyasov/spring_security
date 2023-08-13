package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    void delete(Long id);

}
