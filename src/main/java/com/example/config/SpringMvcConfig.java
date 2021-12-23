package com.example.config;

import com.example.dao.StudentDAO;
import com.example.dao.StudentDAOImpl;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class SpringMvcConfig implements WebMvcConfigurer {
    @Bean
    public DataSource getDataSource(){ //postgres connection inputları
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        //1:13:!3
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("crud_db");
        dataSource.setUser("postgres");
        dataSource.setPassword("neo123");

        return dataSource;
    }

    @Bean
    public ViewResolver getViewResolver(){ //görüntülerin yeri ve uzantıları
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public StudentDAO getStudentDAO(){
        return new StudentDAOImpl(getDataSource());
    }
}
