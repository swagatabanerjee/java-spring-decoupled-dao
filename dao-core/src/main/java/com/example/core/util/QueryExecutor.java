package com.example.core.util;

import java.util.List;

public interface QueryExecutor {
    <T> List<T> queryForList(String query, Object[] params, RowMapperStrategy<T> rowMapper);
    <T> T queryForObject(String query, Object[] params, RowMapperStrategy<T> rowMapper);
    int update(String query, Object[] params);
    int insert(String query, Object[] params);
    int delete(String query, Object[] params);
}
