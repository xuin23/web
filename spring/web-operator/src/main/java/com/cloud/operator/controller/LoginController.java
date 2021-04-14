package com.cloud.operator.controller;

import com.cloud.auth.common.bean.Authorization;
import com.cloud.common.bean.ResultBean;
import com.cloud.operator.remote.LoginClient;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 操作员登录接口
 */
@Slf4j
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    /**
     * 用户登录客户端
     */
    @Resource
    private LoginClient loginClient;

    /**
     * 发送验证码
     *
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @GetMapping(value = "/securityCode")
    private ResultBean<String> securityCode(@RequestParam(value = "username") String username) {
        if (!username.contains("@")) {
            return ResultBean.FAIL("Please Login With Email");
        }
        loginClient.securityCode(username);
        return ResultBean.SUCCESS("Email send success" + username);
    }

    /**
     * 操作员登录
     *
     * @param request      请求信息
     * @param username     用户名
     * @param password     密码
     * @param securityCode 验证码
     * @return ResultsBean<Authorization>
     */
    @PostMapping(value = "/Login")
    private ResultBean<Authorization> login(HttpServletRequest request,
                                            @RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
                                            @RequestParam(value = "securityCode", required = false) String securityCode) {
        String remoteIp = request.getRemoteAddr();
        log.info("username : {},security code : {}，ip : {}", username, securityCode, remoteIp);
        return loginClient.login(username, password, true, securityCode);
    }

    /**
     * 注册
     *
     * @param username     用户名
     * @param securityCode 验证码
     * @return ResultsBean<Authorization>
     */
    @PostMapping(value = "/register")
    private ResultBean<Authorization> register(@RequestParam(value = "username") String username,
                                               @RequestParam(value = "securityCode") String securityCode) {
        log.info("用户名：{}，验证码：{}", username, securityCode);
        ResultBean<Authorization> resultsBean = loginClient.register(username, securityCode);
        if (resultsBean.success()) {
            log.info("用户登录：{}，返回结果：{}", username, resultsBean.getObject());
        }
        return resultsBean;
    }

}
