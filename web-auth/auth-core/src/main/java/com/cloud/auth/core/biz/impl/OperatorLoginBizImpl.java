package com.cloud.auth.core.biz.impl;

import com.cloud.auth.common.bean.Authorization;
import com.cloud.auth.common.constants.AuthConstants;
import com.cloud.auth.core.biz.OperatorLoginBiz;
import com.cloud.auth.core.service.AuthUserRoleService;
import com.cloud.auth.core.service.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.auth.entity.AuthUserRole;
import com.cloud.common.enums.Status;
import com.cloud.common.utils.DigestUtil;
import com.cloud.message.common.constant.MessageConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
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
     * 用户角色关联 service
     */
    @Resource
    private AuthUserRoleService authUserRoleService;

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
        //验证码校验
        securityCodeCheck(username, isSecurity, securityCode);

        List<AuthUser> authUserList = authUserService.findByEmail(username);
        AuthUser authUser = null;
        if (authUserList.size() == 1) {
            authUser = authUserList.get(0);
        }
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
        redisTemplate.opsForValue().set(AuthConstants.LOGIN_TOKEN_USER_PREFIX + token, auth);
        log.info("App 用户登陆：{}，登陆成功，设置 token：{}", username, token);
        return auth;
    }

    /**
     * 注册
     *
     * @param username     用户名
     * @param securityCode 验证码
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Authorization register(String username, String securityCode) {
        //验证码校验
        securityCodeCheck(username, true, securityCode);
        //验证邮箱是否存在
        emailCheck(username);
        //创建用户
        AuthUser authUser = new AuthUser();
        authUser.setEmail(username);
        authUser.setPassword(DigestUtil.encodeByMd5("123456"));  //默认密码123456
        authUser.setStatus(Status.t);

        AuthUserRole authUserRole = new AuthUserRole();
        Long id = authUserService.create(authUser);
        //创建角色关联
        authUserRole.setUserId(id);
        authUserRole.setRoleId(2L);
        authUserRoleService.create(authUserRole);

        Authorization authorization = new Authorization();
        authorization.setEmail(username);
        return authorization;
    }

    /**
     * 邮箱验证
     *
     * @param email 邮箱
     */
    private void emailCheck(String email) {
        List<AuthUser> authUserList = authUserService.findByEmail(email);
        if (!authUserList.isEmpty()) {
            throw new RuntimeException("当前邮箱已存在:" + email);
        }
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
            String key = MessageConstants.EMAIL_SECURITY_PREFIX + username;
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
