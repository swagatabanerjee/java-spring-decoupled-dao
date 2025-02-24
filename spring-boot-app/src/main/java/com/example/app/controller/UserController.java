package com.example.app.controller;

import com.example.core.model.User;
import com.example.core.dao.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public List<User> getUsers() {
        return userDao.findAllUsers();
    }
}
