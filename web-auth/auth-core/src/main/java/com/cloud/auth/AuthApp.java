package com.cloud.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cloud"})
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }

}

