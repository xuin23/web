package com.cloud.auth.core.cloud;

import com.cloud.auth.core.biz.OperatorLoginBiz;
import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 操作员登录 provider
 */
@Slf4j
@RestController
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
     * @param securityCode 验证码
     * @return
     */
    public ResultsBean<Authorization> login(@RequestParam(value = "username") String username,
                                            @RequestParam(value = "password") String password,
                                            @RequestParam(value = "securityCode") String securityCode) {

        Authorization authorization = operatorLoginBiz.login(username, password, securityCode);
        log.info("用户登录：{}，返回结果：{}", username, authorization);
        return ResultsBean.SUCCESS(authorization);
    }

}
