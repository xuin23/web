package com.cloud.sms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.cloud"})
@EnableFeignClients(basePackages = {"com.cloud.sms.remote"})
public class SmsApp {
    public static void main(String[] args) {
        SpringApplication.run(SmsApp.class, args);
    }
}
