package com.cloud.test.jpa.service;


import com.cloud.test.jpa.bean.AuthUser;
import com.cloud.test.jpa.dao.AuthUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 service
 */
@Slf4j
@Service
public class AuthUserService {

    /**
     * 用户 mapper
     */
    @Resource
    private AuthUserRepository authUserRepository;


    public List<AuthUser> findAll() {
        return authUserRepository.findAll();
    }



}
