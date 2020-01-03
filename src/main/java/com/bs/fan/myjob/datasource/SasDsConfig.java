package com.bs.fan.myjob.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bs.fan.myjob.mapper.sas",sqlSessionFactoryRef =
        "sasSqlSessionFactory")
public class SasDsConfig {

    @Bean(name="sasDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sas")
    public DataSource sasDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sasSqlSessionFactory")
    @Primary
    public SqlSessionFactory sasSqlSessionFactory(@Qualifier("sasDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "sasTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("sasDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sasSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sasSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
