package com.cloud.demo.jpa.dao;

import com.cloud.demo.jpa.bean.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

}
