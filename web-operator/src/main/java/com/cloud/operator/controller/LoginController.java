package com.cloud.operator.controller;

import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.operator.mq.EmailProducer;
import com.cloud.operator.remote.LoginClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * Email mq
     */
    @Resource
    private EmailProducer emailProducer;

    /**
     * 发送验证码
     *
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @PostMapping(value = "/loginSecurityCode")
    private ResultsBean<String> securityCode(@RequestParam(value = "username") String username) {
        if (!username.contains("@")) {
            throw new RuntimeException("请输入邮箱");
        }
        log.info("获取验证码：{}", username);
        try {
            emailProducer.sendEmailMessage(username);
        } catch (Exception e) {
            log.error("发送验证码错误");
            return ResultsBean.FAIL(username);
        }
        log.info("验证码发送完成,{}", username);
        return ResultsBean.SUCCESS("验证码发送成功" + username);
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
    @PostMapping(value = "/operatorLogin")
    private ResultsBean<Authorization> login(HttpServletRequest request,
                                             @RequestParam(value = "username") String username,
                                             @RequestParam(value = "password") String password,
                                             @RequestParam(value = "securityCode", required = false) String securityCode) {
        String remoteIp = request.getRemoteAddr();
        log.info("用户名：{}，验证码：{}，ip地址：{}", username, securityCode, remoteIp);
        ResultsBean<Authorization> resultsBean = loginClient.login(username, password, true, securityCode);
        if (resultsBean.success()) {
            log.info("用户登录：{}，返回结果：{}", username, resultsBean.getObject());
        }
        return resultsBean;
    }

    /**
     * 注册登录
     *
     * @param username     用户名
     * @param securityCode 验证码
     * @return ResultsBean<Authorization>
     */
    @PostMapping(value = "/register")
    private ResultsBean<Authorization> register(@RequestParam(value = "username") String username,
                                                @RequestParam(value = "securityCode") String securityCode) {
        log.info("用户名：{}，验证码：{}", username, securityCode);
        ResultsBean<Authorization> resultsBean = loginClient.register(username, securityCode);
        if (resultsBean.success()) {
            log.info("用户登录：{}，返回结果：{}", username, resultsBean.getObject());
        }
        return resultsBean;
    }

}
