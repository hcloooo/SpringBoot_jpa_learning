package com.nacl.jpa_learning.service.impl;

import com.nacl.jpa_learning.pojo.Admin;
import com.nacl.jpa_learning.service.JdbcTemplateAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
@Service
public class JdbcTemplateAdminServiceImpl implements JdbcTemplateAdminService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //获取映射关系
    public RowMapper<Admin> getAdminMapper(){
        //使用Lambda构建Admin映射关系
        RowMapper<Admin> adminRowMapper = (ResultSet rs, int rownum) -> {
            Admin admin = new Admin();
            admin.setId(rs.getInt("Id"));
            admin.setName(rs.getString("Name"));
            admin.setNote(rs.getString("Note"));
            admin.setPwd(rs.getString("Pwd"));
            admin.setState(rs.getInt("State"));
            return admin;
        };
        return adminRowMapper;
    }
    @Override
    public List selectAll() {
        return null;
    }
    @Override
    public Admin getAdminById(int id) {
        String sql = "select * from Admin where id= ?";
        Object[] parms = new Object[] { id };
        Admin admin = jdbcTemplate.queryForObject(sql, parms, getAdminMapper());
        return admin;
    }

    @Override
    public int AddUser() {
        String sql = "delete FROM Admin where name='nacl'";
        jdbcTemplate.execute(sql);
        return 0;
    }
}
