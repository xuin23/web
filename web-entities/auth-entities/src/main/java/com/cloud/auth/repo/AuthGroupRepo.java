package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthGroup;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 用户组 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthGroupRepo extends JpaRepositoryImplementation<AuthGroup, Long> {

}
