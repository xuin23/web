package com.cloud.test.jpa.controller;

import com.cloud.test.jpa.bean.AuthUser;
import com.cloud.test.jpa.service.AuthUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController(value = "/authUser")
public class AuthUserController {

    @Resource
    private AuthUserService authUserService;

    @GetMapping(value = "/")
    public List<AuthUser> findAuthUser() {
        return authUserService.findAll();
    }

    @GetMapping(value = "/{id}")
    public String fun1(@PathVariable("id") Long id) {
        return String.valueOf(id);
    }
    @GetMapping(value = "/de")
    public String fun1() {
        return "de";
    }

}

class AExcption extends RuntimeException{
    public AExcption() {
        super();
    }

    public AExcption(String message) {
        super(message);
    }

    public AExcption(String message, Throwable cause) {
        super(message, cause);
    }

    public AExcption(Throwable cause) {
        super(cause);
    }

    protected AExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
