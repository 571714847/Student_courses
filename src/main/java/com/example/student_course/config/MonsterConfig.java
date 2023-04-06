package com.example.student_course.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MonsterConfig {
    //自动加载application.properties/yml/yaml
    //@ConfigurationProperties("druid.datasource")
    //@Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
