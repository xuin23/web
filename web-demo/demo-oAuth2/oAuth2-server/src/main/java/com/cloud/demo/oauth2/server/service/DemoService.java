package com.cloud.demo.oauth2.server.service;

import com.cloud.auth.entity.AuthRole;
import com.cloud.auth.mapper.AuthRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    @Resource
    private AuthRoleMapper authRoleMapper;

    public AuthRole demo() {
        return authRoleMapper.findById(1L);
    }

}
