package com.cloud.auth.repo;

import com.cloud.entity.AuthRoleAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色权限关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthRoleAuthorityRepo extends JpaRepository<AuthRoleAuthority, Long> {

}
