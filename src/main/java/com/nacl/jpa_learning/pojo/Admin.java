package com.nacl.jpa_learning.pojo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin{
    public Admin(int id, String name, String pwd, String note, int state) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.note = note;
        State = state;
    }

    public int id;
    public String name;
    public String pwd;
    public String note;
    public int State;

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
