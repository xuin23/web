package com.cloud.auth.core.biz.impl;

import com.cloud.auth.core.biz.OperatorLoginBiz;
import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.Authorization;
import com.cloud.common.constant.CacheKeyConstants;
import com.cloud.common.utils.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

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
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 操作员登录
     *
     * @param username     用户名
     * @param password     密码
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     * @return Authorization
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Authorization login(String username, String password, Boolean isSecurity, String securityCode) {
        log.info("操作员 用户登录：{}", username);

        //验证码校验
        securityCodeCheck(username, isSecurity, securityCode);

        AuthUser authUser = authUserService.findByEmail(username);
        if (null == authUser || !Objects.equals(DigestUtil.encodeByMd5(password), authUser.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        Authorization auth = new Authorization();
        auth.setId(authUser.getId());
        auth.setEmail(authUser.getEmail());
        auth.setUsername(authUser.getUsername());
        auth.setRealname(authUser.getRealname());
        //生成token
        String token = DigestUtil.encodeByMd5(authUser.getUsername() + System.currentTimeMillis());
        auth.setToken(token);
        //设置登录缓存
        redisTemplate.opsForValue().set(CacheKeyConstants.LOGIN_TOKEN_USER_PREFIX + token, auth);
        log.info("App 用户登陆：{}，登陆成功，设置 token：{}", username, token);

        return auth;
    }

    /**
     * 验证码校验
     *
     * @param username     用户名
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     */
    private void securityCodeCheck(String username, Boolean isSecurity, String securityCode) {
        if (isSecurity) {
            String key = CacheKeyConstants.EMAIL_SECURITY_PREFIX + username;
            Object o = redisTemplate.opsForValue().get(key);
            if (null != o && securityCode.equals(o.toString())) {
                log.info("验证码校验成功");
            } else {
                log.error("验证码校验失败");
                throw new RuntimeException("验证码校验失败，请重新输入");
            }
        }
    }

}
