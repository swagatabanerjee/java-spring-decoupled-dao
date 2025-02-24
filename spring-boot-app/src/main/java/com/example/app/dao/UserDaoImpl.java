package com.example.app.dao;

import com.example.core.dao.AbstractUserDao;
import com.example.core.model.User;
import com.example.core.strategy.UserRowMapperStrategy;
import com.example.core.util.QueryExecutor;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractUserDao {
    public UserDaoImpl(QueryExecutor queryExecutor) {
        super(queryExecutor, new UserRowMapperStrategy());
    }
}
