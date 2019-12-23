package com.nacl.jpa_learning.service;

import com.nacl.jpa_learning.pojo.Admin;
import com.nacl.jpa_learning.pojo.User;

import java.util.List;

public interface JdbcTemplateAdminService {
    public List selectAll();
    public Admin getAdminById(int id);
    public int AddUser();
}
