package com.nacl.jpa_learning.dao;

import com.nacl.jpa_learning.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findAdminById(int id);
    List<Admin> findAll();
}
