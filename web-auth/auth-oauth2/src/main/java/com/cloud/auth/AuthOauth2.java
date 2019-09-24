package com.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class AuthOauth2 {
    public static void main(String[] args) {
        SpringApplication.run(AuthOauth2.class, args);
    }
}
