package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthUserGroup;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 用户用户组关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserGroupRepo extends JpaRepositoryImplementation<AuthUserGroup, Long> {

}
