package com.cloud.auth.service.auth;

import com.cloud.auth.base.BaseService;
import com.cloud.auth.entity.AuthUserRole;
import com.cloud.auth.repo.AuthUserRoleRepo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色关联 service
 *
 * @author xulijian
 */
@Service
public class AuthUserRoleService extends BaseService<AuthUserRole, Long> {

    /**
     * 用户 repo
     */
    @Resource
    private AuthUserRoleRepo authUserRoleRepo;

    /**
     * 获得指定AuthUserRepo
     *
     * @author xulijian
     */
    @Override
    public JpaRepositoryImplementation<AuthUserRole, Long> getRepository() {
        return authUserRoleRepo;
    }
}
