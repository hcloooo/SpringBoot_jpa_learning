package com.nacl.jpa_learning.service;

import com.nacl.jpa_learning.pojo.Admin;
import com.nacl.jpa_learning.pojo.User;

import java.util.List;

public interface JdbcTemplateAdminService {
    public List selectAll();
    public Admin getAdminById(int id);
    public Admin getAdminByIdOrName(String name, int id);
    public Admin getAdminByPstm();
    public Admin getAdminByConn();
    public int AddUser();
}
