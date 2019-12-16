package com.cloud.auth.core;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.cloud"})
@MapperScan(value = "com.cloud.auth.mapper")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cloud.auth.repo")
@EntityScan("com.cloud.auth.jpa")
@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

