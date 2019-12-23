package com.nacl.jpa_learning.service.impl;

import com.nacl.jpa_learning.pojo.Admin;
import com.nacl.jpa_learning.service.JdbcTemplateAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
    public Admin getAdminByIdOrName(String name, int id) {
        String sql = "select * from Admin where name=? and id=?";
       /* List<Object> parms = new ArrayList<>();
        parms.add(name);
        parms.add(id);*/
       Object[] parms = new Object[] { name, id };
        Admin admin =(Admin) jdbcTemplate.queryForObject(sql, parms , getAdminMapper());
        return admin;
    }

    @Override
    public Admin getAdminByPstm() {
        Admin admin = this.jdbcTemplate.execute((Statement statement) -> {
            String sql = "select count(*) as total from Admin";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int total = rs.getInt("total");
                System.out.println(total);
            }
            String sql2 = "select * from Admin where id=190103";
            ResultSet rs2 = statement.executeQuery(sql2);
            Admin admin2 = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                admin2 = getAdminMapper().mapRow(rs2, rowNum);
            }
            return admin2;
        });
        return admin;
    }

    @Override
    public Admin getAdminByConn() {
        return this.jdbcTemplate.execute((Connection conn ) -> {
            String sql = "select count(*) as total from Admin";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt("total");
                System.out.println(total);
            }
            String sql2 = "select * from Admin where id=190103";
            PreparedStatement preparedStatement2  = conn.prepareStatement(sql2);
            ResultSet rs2 = preparedStatement2.executeQuery();
            Admin admin2 = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                admin2 = getAdminMapper().mapRow(rs2, rowNum);
            }
            return admin2;
        });
    }

    @Override
    public int AddUser() {
        String sql = "insert into Admin values (null,'nacl','123','nothing',1)";
        jdbcTemplate.execute(sql);
        return 0;
    }

}
