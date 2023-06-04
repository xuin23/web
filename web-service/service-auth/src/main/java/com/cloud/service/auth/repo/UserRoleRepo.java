package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.Structure_user_role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联 repo
 *
 * @author xulijian
 */
@Repository
public interface UserRoleRepo extends JpaRepositoryImplementation<Structure_user_role, Long> {

}
