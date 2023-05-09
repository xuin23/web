package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.AuthUserRole;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserRoleRepo extends JpaRepositoryImplementation<AuthUserRole, Long> {

}
