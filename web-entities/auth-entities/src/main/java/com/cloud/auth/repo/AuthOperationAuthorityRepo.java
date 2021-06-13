package com.cloud.auth.repo;

import com.cloud.entity.AuthOperationAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 权限操作关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthOperationAuthorityRepo extends JpaRepository<AuthOperationAuthority, Long> {

}
