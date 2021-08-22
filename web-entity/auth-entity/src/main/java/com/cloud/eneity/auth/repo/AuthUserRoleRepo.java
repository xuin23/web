package com.cloud.eneity.auth.repo;

import com.cloud.eneity.auth.entity.AuthUserRole;
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
