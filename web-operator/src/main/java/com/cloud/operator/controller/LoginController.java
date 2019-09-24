package com.cloud.operator.controller;

import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.LoginConstants;
import com.cloud.operator.remote.EmailClient;
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
     * 邮箱客户端
     */
    @Resource
    private EmailClient emailClient;


    /**
     * 发送验证码
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @PostMapping(value = "/loginSecurityCode")
    private ResultsBean<String> securityCode(@RequestParam(value = "username") String username) {
        if (!username.contains("@")) {
            throw new RuntimeException("请输入邮箱");
        }
        log.info("获取验证码：{}", username);
        ResultsBean<String> resultsBean = emailClient.sendEmail(username);
        if (!resultsBean.success()) {
            return ResultsBean.FAIL(resultsBean.getMessage());
        }
        log.info("验证码发送完成");
        return ResultsBean.SUCCESS("验证码发送成功");
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
        //保存登录 session
        request.getSession().setAttribute(LoginConstants.AUTHORIZATION, resultsBean.getObject());
        return resultsBean;
    }

}
