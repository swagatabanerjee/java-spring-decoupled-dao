package com.example.core.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapperStrategy<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
