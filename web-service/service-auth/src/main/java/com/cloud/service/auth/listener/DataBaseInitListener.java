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
            user.setUid("admin");
            user.setName("系统管理员");
            user.setEmail("xuin23@outlook.com");
            user.setPassword(DigestUtil.encodeByMd5("admin"));
            authUserRepo.save(user);
        }
    }
}
