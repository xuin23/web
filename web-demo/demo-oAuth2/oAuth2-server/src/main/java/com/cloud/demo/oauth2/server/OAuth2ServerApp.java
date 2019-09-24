package com.cloud.demo.oauth2.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cloud"})
@MapperScan(value = "com.cloud.auth.mapper")
@SpringBootApplication
@EnableEurekaClient
public class OAuth2ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApp.class, args);
    }
}
