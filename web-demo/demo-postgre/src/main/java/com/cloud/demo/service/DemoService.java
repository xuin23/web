package com.cloud.demo.service;

import com.cloud.demo.dao.DemoDao;
import com.cloud.demo.module.AuthUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {
    @Resource
    private DemoDao demoDao;

    public List<AuthUser> getAuthUser() {
        return demoDao.getAuthUser();
    }
}
