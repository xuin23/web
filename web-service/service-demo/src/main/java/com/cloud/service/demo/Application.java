package com.cloud.service.demo;

import com.cloud.frame.spring.common.Timing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Application {


    @Timing
    @GetMapping("/random")
    public String random() {
        return String.valueOf((int) (Math.random() * 1000));
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
