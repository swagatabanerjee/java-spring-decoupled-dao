package com.example.core.util;
import java.sql.*;
import javax.sql.DataSource;

public interface QueryExecutor {
    <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... params);
}