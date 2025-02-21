package com.example.core.dao;
import com.example.core.model.User;
public interface UserDao {
    User findById(int id);
}