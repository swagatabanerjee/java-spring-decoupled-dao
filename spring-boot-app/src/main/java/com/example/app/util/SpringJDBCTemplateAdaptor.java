package com.example.app.util;

import com.example.core.util.QueryExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJDBCTemplateAdaptor {
    private final JdbcTemplate jdbcTemplate;
    private final QueryExecutor queryExecutor;

    public SpringJDBCTemplateAdaptor(JdbcTemplate jdbcTemplate, QueryExecutor queryExecutor) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryExecutor = queryExecutor;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public QueryExecutor getQueryExecutor() {
        return queryExecutor;
    }
}
