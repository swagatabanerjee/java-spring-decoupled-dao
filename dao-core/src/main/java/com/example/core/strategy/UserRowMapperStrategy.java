package com.example.core.strategy;

import com.example.core.model.User;
import com.example.core.util.RowMapperStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapperStrategy implements RowMapperStrategy<User> {
    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("name"));
    }
}
