package com.cloud.auth.core.service.auth;

import com.cloud.common.base.BaseService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.auth.mapper.AuthUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 service
 */
@Slf4j
@Service
public class AuthUserService extends BaseService<AuthUser> {

    /**
     * 用户 mapper
     */
    @Resource
    private AuthUserMapper authUserMapper;

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return AuthUser
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AuthUser> findByEmail(String email) {
        log.info("email {}", email);
        return authUserMapper.findByEmail(email);
    }

}
