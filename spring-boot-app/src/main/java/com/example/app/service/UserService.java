package com.example.app.service;

import com.example.app.dao.UserDaoImpl;
import com.example.core.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void createUser(User user) {
        userDao.insertUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User getUserById(int id) {
        return userDao.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }
}
