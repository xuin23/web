package com.cloud.operator.controller;

import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.operator.remote.AuthUserClient;
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
    private AuthUserClient authUserClient;


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
                                             @RequestParam(value = "username") String username,
                                             @RequestParam(value = "password") String password,
                                             @RequestParam(value = "securityCode",required = false) String securityCode) {
        String remoteIp = request.getRemoteAddr();
        log.info("用户名：{}，验证码：{}，ip地址：{}", username, securityCode, remoteIp);
        ResultsBean<Authorization> resultsBean = authUserClient.login(username, password, false, securityCode);
        if (resultsBean.success()) {
            log.info("用户登录：{}，返回结果：{}", username, resultsBean.getObject());
        }
        return resultsBean;
    }

}
