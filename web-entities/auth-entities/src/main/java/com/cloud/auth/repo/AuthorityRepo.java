package com.cloud.auth.repo;

import com.cloud.auth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 权限 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {

}
