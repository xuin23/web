package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthOperationAuthority;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 权限操作关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthOperationAuthorityRepo extends JpaRepositoryImplementation<AuthOperationAuthority, Long> {

}
