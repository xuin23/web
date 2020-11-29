package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserRoleRepo extends JpaRepository<AuthUserRole, Long> {

}
