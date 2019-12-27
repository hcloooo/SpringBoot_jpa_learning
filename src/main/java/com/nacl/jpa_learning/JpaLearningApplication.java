package com.nacl.jpa_learning;

import com.nacl.jpa_learning.dao.MybatisDepartmentDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//定义SpringBoot扫描包路径
@SpringBootApplication(scanBasePackages = {"com.nacl.jpa_learning"})
//定义JPA接口扫描路径
@EnableJpaRepositories(basePackages = {"com.nacl.jpa_learning.dao"})
//定义实体Bean扫描路径
@EntityScan(basePackages = {"com.nacl.jpa_learning.pojo"})
/*
@MapperScan(
        //指定扫描包
        basePackages = "com.nacl.jpa_learning",
        //指定SqlSessionFactory，如果sqlSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //指定sqlSessionTemplate，将忽略sqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //markerInterface = Class.class,//限定扫描接口，不常用
        annotationClass = Repository.class
)
*/
@MapperScan("com.nacl.jpa_learning.dao")
public class JpaLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLearningApplication.class, args);
    }
   /* @Autowired
    SqlSessionFactory sqlSessionFactory = null;

    @Bean
    public MapperFactoryBean<MybatisDepartmentDao> initMyBatisUserDao() {
        MapperFactoryBean<MybatisDepartmentDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(MybatisDepartmentDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }
*/

  /*  @Bean
    public MapperScannerConfigurer mapperScannerConfig() {
        //定义扫描器实例
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //加载SqlSessionFactory,Spring Boot会自动生产，SqlSessionFactory实例，无需我们敢于
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //定义扫描的包
        mapperScannerConfigurer.setBasePackage("com.nacl.jpa_learning.dao.*");
        //限定被标注@Repository的接口才被扫描
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        //通过继承某个接口限制扫描，一般使用不多
        //mapperScannerConfigurer.setMarkerInterface(。。。。。。);
        return mapperScannerConfigurer;
    }*/

}
