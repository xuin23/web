package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthRoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色用户组关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthRoleGroupRepo extends JpaRepository<AuthRoleGroup, Long> {

}
