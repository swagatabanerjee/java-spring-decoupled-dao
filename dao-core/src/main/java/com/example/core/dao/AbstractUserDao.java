package com.example.core.dao;

import com.example.core.model.User;
import com.example.core.strategy.UserRowMapperStrategy;
import com.example.core.util.QueryExecutor;

import java.util.List;

public abstract class AbstractUserDao {
    protected final QueryExecutor queryExecutor;
    protected final UserRowMapperStrategy rowMapperStrategy;

    protected AbstractUserDao(QueryExecutor queryExecutor, UserRowMapperStrategy rowMapperStrategy) {
        this.queryExecutor = queryExecutor;
        this.rowMapperStrategy = rowMapperStrategy;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO users (id, name) VALUES (?, ?)";
        queryExecutor.insert(sql, new Object[]{user.getId(), user.getName()});
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        queryExecutor.update(sql, new Object[]{user.getName(), user.getId()});
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        queryExecutor.delete(sql, new Object[]{userId});
    }

    public User findUserById(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return queryExecutor.queryForObject(sql, new Object[]{userId}, rowMapperStrategy);
    }

    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";
        return queryExecutor.queryForList(sql, new Object[]{}, rowMapperStrategy);
    }
}
