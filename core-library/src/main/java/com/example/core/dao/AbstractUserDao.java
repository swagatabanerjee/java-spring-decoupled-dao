package com.my.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractUserDao {
    private final QueryExecutor queryExecutor;

    public AbstractUserDao(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    public User findById(int id) {
        String sql = "SELECT id, name, email FROM users WHERE id = ?";
        return queryExecutor.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        }, id);
    }
}
