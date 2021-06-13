package com.cloud.auth.repo;

import com.cloud.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户组 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthGroupRepo extends JpaRepository<AuthGroup, Long> {

}
