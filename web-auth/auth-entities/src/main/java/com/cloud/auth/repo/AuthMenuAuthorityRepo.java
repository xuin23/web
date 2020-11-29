package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthMenuAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 权限菜单关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthMenuAuthorityRepo extends JpaRepository<AuthMenuAuthority, Long> {

}
