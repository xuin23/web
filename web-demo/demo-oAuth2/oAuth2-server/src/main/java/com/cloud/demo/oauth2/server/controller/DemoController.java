package com.cloud.demo.oauth2.server.controller;

import com.cloud.auth.entity.AuthRole;
import com.cloud.demo.oauth2.server.service.DemoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/")
    public String demo(Model model) {
        AuthRole authRole = demoService.demo();
        model.addAttribute("authRole", authRole);
        return "asd";
    }
}
