package com.cloud.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@ComponentScan(basePackages = {"com.cloud"})
@SpringBootApplication
@RestController
public class Application {



    @GetMapping
    public Object o() throws IOException {
        return null;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
