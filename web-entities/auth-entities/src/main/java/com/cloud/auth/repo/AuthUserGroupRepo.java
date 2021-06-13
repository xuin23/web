package com.cloud.auth.repo;

import com.cloud.entity.AuthUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户用户组关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserGroupRepo extends JpaRepository<AuthUserGroup, Long> {

}
