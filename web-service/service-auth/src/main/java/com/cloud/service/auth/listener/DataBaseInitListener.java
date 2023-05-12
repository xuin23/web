package com.cloud.service.auth.listener;

import com.cloud.common.common.util.DigestUtil;
import com.cloud.service.auth.entity.AuthUser;
import com.cloud.service.auth.repo.AuthUserRepo;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DataBaseInitListener implements ApplicationListener<ApplicationStartedEvent> {

    @Lazy
    @Resource
    AuthUserRepo authUserRepo;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {

        if (authUserRepo.count()==0L) {
            AuthUser authUser = new AuthUser();
            authUser.setUid("admin");
            authUser.setName("系统管理员");
            authUser.setEmail("xuin23@outlook.com");
            authUser.setPassword(DigestUtil.encodeByMd5("admin"));
            authUserRepo.save(authUser);
        }
    }
}
