package com.cloud.test.config.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController(value = "authUser")
public class AuthUserController {


    @GetMapping(value = "/{id}")
    public String fun1(@PathVariable("id") Long id) {
        return String.valueOf(id);
    }

    @GetMapping(value = "/de")
    public String fun1() {
        return "de";
    }
}
