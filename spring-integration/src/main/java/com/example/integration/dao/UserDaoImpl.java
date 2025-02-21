package com.example.integration.dao;
import com.example.core.dao.AbstractUserDao;
import com.example.core.util.QueryExecutor;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl extends AbstractUserDao {
    public UserDaoImpl(QueryExecutor queryExecutor) {
        super(queryExecutor);
    }
}