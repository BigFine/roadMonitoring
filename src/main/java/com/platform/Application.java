package com.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling//开启定时任务
@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
        return application.sources(Application.class);  
    } 
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    
}
