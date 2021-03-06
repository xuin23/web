package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthRole;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 角色 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthRoleRepo extends JpaRepositoryImplementation<AuthRole, Long> {

}
