package com.example.demo.config;

import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import com.querydsl.sql.types.DateTimeType;
import com.querydsl.sql.types.LocalDateType;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration

public class AppConfig {

// @Bean
//   public SQLQueryFactory queryFactory(DataSource dataSource) {
//
//
//        SpringConnectionProvider provider=new SpringConnectionProvider(dataSource);
//        SQLTemplates templates=new H2Templates().builder().printSchema().build();
//        com.querydsl.sql.Configuration configuration=new com.querydsl.sql.Configuration(templates);
//        configuration.setExceptionTranslator(new SpringExceptionTranslator());
//        configuration.register(new DateTimeType());
//        configuration.register(new LocalDateTimeType());
//        configuration.register(new TimestampType());
//        return new SQLQueryFactory(configuration,provider);
//   }
////
//    @Bean
//    public SQLQueryFactory queryFactory(DataSource dataSource) {
//        SpringConnectionProvider provider = new SpringConnectionProvider(dataSource);
//
//        SQLTemplates templates = new H2Templates().builder().printSchema().build();
//        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
//        configuration.setExceptionTranslator(new SpringExceptionTranslator());
//        configuration.register(new DateTimeType());
//        configuration.register(new LocalDateType());
//        configuration.register(new TimestampType());
//
//        return new SQLQueryFactory(configuration, provider);
//    }
//
//    @Bean
//    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
//        return new JPAQueryFactory(entityManager);
//    }

   @Inject
   Environment env;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        dataSource.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.user"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public com.querydsl.sql.Configuration querydslConfiguration() {
        SQLTemplates templates = H2Templates.builder().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        configuration.register(new DateTimeType());
        configuration.register(new LocalDateType());
        return configuration;
    }

    @Bean
    public SQLQueryFactory queryFactory() {
        SpringConnectionProvider provider = new SpringConnectionProvider(dataSource());
        return new SQLQueryFactory(querydslConfiguration(), provider);
    }
}
