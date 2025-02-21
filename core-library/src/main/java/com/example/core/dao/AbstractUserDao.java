package com.example.core.dao;
import com.example.core.model.User;
import com.example.core.util.QueryExecutor;
public abstract class AbstractUserDao implements UserDao {
    private final QueryExecutor queryExecutor;
    public AbstractUserDao(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }
    @Override
    public User findById(int id) {
        String sql = "SELECT id, name, email FROM users WHERE id = ?";
        return queryExecutor.queryForObject(sql, rs -> new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")), id);
    }
}