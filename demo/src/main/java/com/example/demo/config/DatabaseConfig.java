package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
@Bean
    public PlatformTransactionManager transactionManager (DataSource dataSource)
    {
        DataSourceTransactionManager txManager=new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
