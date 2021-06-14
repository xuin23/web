package com.cloud.auth.repo;

import com.cloud.auth.entity.Authority;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 权限 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthorityRepo extends JpaRepositoryImplementation<Authority, Long> {

}
