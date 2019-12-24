package com.nacl.jpa_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//定义SpringBoot扫描包路径
@SpringBootApplication(scanBasePackages = {"com.nacl.jpa_learning"})
//定义JPA接口扫描路径
@EnableJpaRepositories(basePackages = {"com.nacl.jpa_learning.dao"})
//定义实体Bean扫描路径
@EntityScan(basePackages = {"com.nacl.jpa_learning.pojo"})
public class JpaLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLearningApplication.class, args);
    }

}
