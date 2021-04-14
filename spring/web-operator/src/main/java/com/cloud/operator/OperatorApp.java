package com.cloud.operator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.cloud"})
@EnableFeignClients(basePackages = {"com.cloud.operator.remote"})
public class OperatorApp {
    public static void main(String[] args) {
        SpringApplication.run(OperatorApp.class, args);
    }
}
