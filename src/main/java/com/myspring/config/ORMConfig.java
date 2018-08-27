package com.myspring.config;

import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * created by xuyuan 18/8/26
 */
@Configuration
@PropertySource({"classpath:application.properties"})
@Data
@EnableTransactionManagement
public class ORMConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.hibernate.dialect}")
    private String dialect;
    @Value("${jdbc.hibernate.show_sql}")
    private String showSql;
    @Value("${jdbc.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("jdbc.hibernate.format_sql")
    private String formatSql;

    /**
     * 异常转换
     * @return
     */
//    @Bean
//    public BeanPostProcessor postProcessor() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }


    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource());
        sfb.setPackagesToScan("com.myspring.entity");
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", getDialect());
        prop.setProperty("hibernate.show_sql", getShowSql());
        prop.setProperty("hibernate.hbm2ddl.auto", getHbm2ddlAuto());
        prop.setProperty("hibernate.format_sql", getFormatSql());
        sfb.setHibernateProperties(prop);
        return sfb;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(getUsername());
        dataSource.setPassword(getPassword());
        dataSource.setUrl(getUrl());
        dataSource.setDriverClassName(getDriverClassName());
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(20);
        return dataSource;
    }

//    @Bean(name="transactionManager")
//    @Autowired
//    @Required
//    public HibernateTransactionManager transactionManager(SessionFactory s) {
//        HibernateTransactionManager txManager=new HibernateTransactionManager();
//        txManager.setSessionFactory(s);
//        return txManager;
//    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

//    public String getDriverClassName() {
//        return driverClassName;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//
//
//    @Value("${jdbc.driverClassName}")
//    public void setDriverClassName(String driverClassName) {
//        this.driverClassName = driverClassName;
//    }
//
//    @Value("${jdbc.url}")
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Value("${jdbc.username}")
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Value("${jdbc.password}")
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
