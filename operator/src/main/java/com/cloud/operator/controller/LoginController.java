package com.cloud.operator.controller;

import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
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
     * 操作员登录
     *
     * @param request      请求信息
     * @param username     用户名
     * @param password     密码
     * @param securityCode 验证码
     * @return
     */
    @PostMapping(value = "/operatorLogin")
    private ResultsBean<Authorization> login(HttpServletRequest request,
                                      @RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("securityCode") String securityCode) {
        String remoteIp = request.getRemoteAddr();
        log.info("用户名：{}，验证码：{}，ip地址：{}", username, securityCode, remoteIp);
        ResultsBean<Authorization> resultsBean = loginClient.login(username, password, securityCode);
        log.info("用户登录：{}，返回结果：{}", username, resultsBean);
        return resultsBean;
    }

}
