package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthOperation;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 操作 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthOperationRepo extends JpaRepositoryImplementation<AuthOperation, Long> {

}
