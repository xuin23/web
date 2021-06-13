package com.cloud.service.auth.service.auth;

import com.cloud.service.auth.base.BaseService;
import com.cloud.entity.AuthUser;
import com.cloud.auth.repo.AuthUserRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户 service
 *
 * @author xulijian
 */
@Service
public class AuthUserService extends BaseService<AuthUser, Long> {

    /**
     * 用户 repo
     */
    @Resource
    private AuthUserRepo authUserRepo;


    /**
     * 获取Repository
     *
     * @return JpaRepository<T, ID>
     */
    @Override
    public JpaRepository<AuthUser, Long> getRepository() {
        return authUserRepo;
    }

    /**
     * 获取JpaSpecificationExecutor
     *
     * @return JpaSpecificationExecutor<AuthUser>
     */
    @Override
    public JpaSpecificationExecutor<AuthUser> getSpecificationExecutor() {
        return authUserRepo;
    }
}
