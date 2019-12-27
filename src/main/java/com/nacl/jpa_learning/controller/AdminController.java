package com.nacl.jpa_learning.controller;

import com.nacl.jpa_learning.dao.AdminRepository;
import com.nacl.jpa_learning.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    //查询用户
    @GetMapping("getAdmins")
    public List<Admin> sayHello(HttpServletResponse response) throws IOException {
        //response.setCharacterEncoding("UTF-8");
        //Admin admin = adminRepository.findAdminById(190102);
        //System.out.println(admin.getName());
        List<Admin> lists = adminRepository.findAll();
        //response.getWriter().println(admin.getPwd());
        return lists;
    }
    //添加一位用户
    @GetMapping("addAdmin")
    public void addAdmin(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Admin admin = new Admin();
        admin.setName("nao");
        admin.setPwd("qwert");
        admin.setNote("haha");
        admin.setState(1);
        int count = adminRepository.save(admin).getState();
        response.getWriter().println(count);
    }
    //更新一条信息
    @RequestMapping("updateAdmin")
    public int updateAdmin(){
        Admin admin = new Admin();
        admin.setName("nao");
        admin.setPwd("qwert");
        admin.setNote("haha");
        admin.setState(1);
        admin.setId(190102);
        int count = adminRepository.save(admin).getState();
        return  count;
    }
    //删除一条信息
    @RequestMapping("deleteAdmin")
    private int deleteAdmin(int id){
        Admin admin = new Admin();
        admin.setId(id);
        adminRepository.deleteById(id);
        return id;
    }


}
