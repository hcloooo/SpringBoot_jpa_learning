package com.nacl.jpa_learning.controller;

import com.nacl.jpa_learning.dao.AdminRepository;
import com.nacl.jpa_learning.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @GetMapping("Admin")
    public List<Admin> sayHello(HttpServletResponse response) throws IOException {
        //response.setCharacterEncoding("UTF-8");
        //Admin admin = adminRepository.findAdminById(190102);
        //System.out.println(admin.getName());
        List<Admin> lists = adminRepository.findAll();
        //response.getWriter().println(admin.getPwd());
        return lists;
    }

}
