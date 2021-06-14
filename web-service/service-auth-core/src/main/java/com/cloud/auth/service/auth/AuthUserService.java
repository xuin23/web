package com.cloud.auth.service.auth;

import com.cloud.auth.base.BaseService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.auth.repo.AuthUserRepo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
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
     * 获得指定AuthUserRepo
     *
     * @author xulijian
     */
    @Override
    public JpaRepositoryImplementation<AuthUser, Long> getRepository() {
        return authUserRepo;
    }
}
