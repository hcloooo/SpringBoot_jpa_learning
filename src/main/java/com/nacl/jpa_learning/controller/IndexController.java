package com.nacl.jpa_learning.controller;

import com.nacl.jpa_learning.pojo.Admin;
import com.nacl.jpa_learning.pojo.User;
import com.nacl.jpa_learning.service.JdbcTemplateAdminService;
import com.nacl.jpa_learning.service.UserService;
import com.nacl.jpa_learning.service.impl.JdbcTemplateAdminServiceImpl;
import com.nacl.jpa_learning.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private  JdbcTemplateAdminService jdbcTemplateAdminService;
    @GetMapping("index")
    public void  index(){
        int i = userService.addUser();
        System.out.println("--------------"+i);

    }
    @GetMapping("getAdmin")
    public void getAdmin(HttpServletResponse  response) throws IOException {
        Admin admin = jdbcTemplateAdminService.getAdminById(190104);
        System.out.println(admin.getName());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(admin.getName());
    }

}
