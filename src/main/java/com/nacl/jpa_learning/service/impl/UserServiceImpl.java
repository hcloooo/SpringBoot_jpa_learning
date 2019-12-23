package com.nacl.jpa_learning.service.impl;

import com.nacl.jpa_learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addUser() {
        String sql = "INSERT INTO USER (USER_NAME,PASS_WORD) VALUES ('dalaoyang','123')";
        int rows= jdbcTemplate.update(sql);
        return 0;
    }
}
