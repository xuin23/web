package com.cloud.auth.repo;

import com.cloud.entity.AuthOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 操作 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthOperationRepo extends JpaRepository<AuthOperation, Long> {

}
