package com.cloud.test.jpa.dao;

import com.cloud.test.jpa.bean.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

}
