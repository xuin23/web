package com.cloud.demo.controller;

import com.cloud.demo.module.AuthUser;
import com.cloud.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping(value = "/")
    public List<AuthUser> asd() {
        List<AuthUser> authUserList = demoService.getAuthUser();
        return authUserList;
    }

}
