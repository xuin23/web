package com.cloud.auth.repo;

import com.cloud.entity.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthRoleRepo extends JpaRepository<AuthRole, Long> {

}
