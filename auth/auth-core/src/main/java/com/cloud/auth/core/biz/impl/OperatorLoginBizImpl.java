package com.cloud.auth.core.biz.impl;

import com.cloud.auth.core.biz.OperatorLoginBiz;
import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 操作员登录 业务
 */
@Slf4j
@Component
public class OperatorLoginBizImpl implements OperatorLoginBiz {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * redis
     */
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 操作员登录
     *
     * @param username     用户名
     * @param password     密码
     * @param securityCode 验证码
     * @return
     */
    @Override
    public Authorization login(String username, String password, String securityCode) {
        log.info("操作员 用户登录：{}", username);
        AuthUser authUser = authUserService.findByUserName(username);
        return null;
    }
}
