package com.cloud.service.auth.listener;

import com.cloud.common.common.util.DigestUtil;
import com.cloud.service.auth.entity.T_User;
import com.cloud.service.auth.repo.UserRepo;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class DataBaseInitListener implements ApplicationListener<ApplicationStartedEvent> {

    @Lazy
    @Resource
    UserRepo userRepo;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {

        if (userRepo.count()==0L) {
            T_User TUser = new T_User();
            TUser.setC_id("admin");
            TUser.setC_name("系统管理员");
            TUser.setC_email("xuin23@outlook.com");
            TUser.setC_password(DigestUtil.encodeByMd5("admin"));
            userRepo.save(TUser);
        }
    }
}
