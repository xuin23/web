package com.cloud.service.auth.listener;

import com.cloud.common.common.util.DigestUtil;
import com.cloud.service.auth.entity.User;
import com.cloud.service.auth.repo.AuthUserRepo;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class DataBaseInitListener implements ApplicationListener<ApplicationStartedEvent> {

    @Lazy
    @Resource
    AuthUserRepo authUserRepo;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {

        if (authUserRepo.count()==0L) {
            User user = new User();
            user.setC_id("admin");
            user.setC_name("系统管理员");
            user.setC_email("xuin23@outlook.com");
            user.setC_password(DigestUtil.encodeByMd5("admin"));
            authUserRepo.save(user);
        }
    }
}
