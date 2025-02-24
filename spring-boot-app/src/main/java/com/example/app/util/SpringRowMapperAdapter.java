package com.example.app.util;

import com.example.core.util.RowMapperStrategy;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper as SpringRowMapper;

public class SpringRowMapperAdapter<T> implements RowMapperStrategy<T> {
    private final RowMapper<T> delegate;

    public SpringRowMapperAdapter(RowMapper<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        return delegate.mapRow(rs, rowNum);
    }

	@Override
	public T mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return delegate.mapRow(rs);;
	}
}
