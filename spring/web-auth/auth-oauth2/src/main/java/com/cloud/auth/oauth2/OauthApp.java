package com.cloud.auth.oauth2;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cloud"})
@MapperScan(value = "com.cloud.auth.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class OauthApp {

    public static void main(String[] args) {
        SpringApplication.run(OauthApp.class, args);
    }

}

