package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthRoleAuthority;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 角色权限关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthRoleAuthorityRepo extends JpaRepositoryImplementation<AuthRoleAuthority, Long> {

}
