package com.alexberemart.homeAccounting.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource", destroyMethod = "close")
    public BasicDataSource getBasicDataSource(
            @Value("${core.datasource.driver}") String driver,
            @Value("${core.datasource.url}") String url,
            @Value("${core.datasource.db.username}") String username,
            @Value("${core.datasource.db.password}") String password,
            @Value("${core.datasource.show.sql}") Boolean testOnBorrow,
            @Value("${core.datasource.validationQuery}") String validationQuery) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setValidationQuery(validationQuery);
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory(
            BasicDataSource dataSource,
            @Value("${core.hibernate.dialect.classname}") String dialect) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.hbm2ddl.auto", "update");
        localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.dialect", dialect);
        return localSessionFactoryBean;
    }

    @Bean(name = "jpaVendorAdapter")
    public HibernateJpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(
            BasicDataSource dataSource,
            HibernateJpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.alexberemart");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getHibernateTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}