package com.cloud.demo.jpa.controller;

import com.cloud.demo.jpa.bean.AuthUser;
import com.cloud.demo.jpa.service.AuthUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController(value = "authUser")
public class AuthUserController {

    @Resource
    private AuthUserService authUserService;

    @GetMapping(value = "/")
    public List<AuthUser> findAuthUser() {
        return authUserService.findAll();
    }

}
