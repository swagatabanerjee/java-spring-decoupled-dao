package com.example.core.util;
import java.sql.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

public class QueryExecutor {
    private final DataSource dataSource;

    public QueryExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... params) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rowMapper.mapRow(rs, 1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database query error", e);
        }
        return null;
    }
}