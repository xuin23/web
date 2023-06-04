package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.T_Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 角色 repo
 *
 * @author xulijian
 */
@Repository
public interface RoleRepo extends JpaRepositoryImplementation<T_Role, Long> {

}
