package com.example.app.util;

import com.example.core.util.QueryExecutor;
import com.example.core.util.RowMapperStrategy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class SpringJDBCQueryExecutor implements QueryExecutor {
    private final JdbcTemplate jdbcTemplate;

    public SpringJDBCQueryExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <T> List<T> queryForList(String query, Object[] params, RowMapperStrategy<T> rowMapper) {
        return (List<T>) jdbcTemplate.query(query, params, rowMapper::mapRow);
    }

    @Override
    public int update(String query, Object[] params) {
        return jdbcTemplate.update(query, params);
    }

    @Override
    public int insert(String query, Object[] params) {
        return jdbcTemplate.update(query, params);
    }

    @Override
    public int delete(String query, Object[] params) {
        return jdbcTemplate.update(query, params);
    }

	@Override
	public <T> T queryForObject(String query, Object[] params, RowMapperStrategy<T> rowMapper) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject(sql, new SpringRowMapperAdapter<>(rowMapper), params);;
	}

	
}
