package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息
 */
public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {

}
