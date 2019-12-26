package com.cloud.test.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

    @GetMapping("/")
    public String TestRequest() {
        return "security";
    }
}
