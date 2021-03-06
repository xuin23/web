package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 用户 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserRepo extends JpaRepositoryImplementation<AuthUser, Long> {

}
