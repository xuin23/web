package com.cloud.auth.core.cloud;

import com.cloud.auth.core.biz.OperatorLoginBiz;
import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 操作员登录 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/operatorLogin")
public class OperatorLoginProvider {

    /**
     * 操作员登录 业务
     */
    @Resource
    private OperatorLoginBiz operatorLoginBiz;

    /**
     * 操作员登录
     *
     * @param username     用户名
     * @param password     密码
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     * @return ResultsBean<Authorization>
     */
    @PostMapping(value = "/login")
    public ResultsBean<Authorization> login(@RequestParam(value = "username") String username,
                                            @RequestParam(value = "password") String password,
                                            @RequestParam(value = "isSecurity") Boolean isSecurity,
                                            @RequestParam(value = "securityCode", required = false) String securityCode) {
        log.info("用户登录：{}", username);
        Authorization authorization = operatorLoginBiz.login(username, password, isSecurity, securityCode);
        log.info("用户登录：{}，返回结果：{}", username, authorization);
        return ResultsBean.SUCCESS(authorization);
    }

    /**
     * 注册
     *
     * @param username     用户名
     * @param securityCode 验证码
     * @return ResultsBean<String>
     */
    @PostMapping(value = "/operatorLogin/register")
    ResultsBean<Authorization> register(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "securityCode") String securityCode) {
        log.info("用户注册：{}，验证码：{}", username, securityCode);
        Authorization authorization = operatorLoginBiz.register(username, securityCode);
        return ResultsBean.SUCCESS(authorization);
    }

}
