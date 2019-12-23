package com.nacl.jpa_learning.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;

public class ShowDataBase implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("----------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("----------------------");
    }
}
