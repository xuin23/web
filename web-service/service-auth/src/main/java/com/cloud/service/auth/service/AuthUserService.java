package com.cloud.service.auth.service;

import com.cloud.service.auth.base.BaseService;
import com.cloud.service.auth.entity.AuthUser;
import com.cloud.service.auth.repo.AuthUserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 用户 service
 *
 * @author xulijian
 */
@Service
public class AuthUserService extends BaseService<AuthUser, Long> {

    @Resource
    AuthUserRepo authUserRepo;

    public List<AuthUser> findAllByCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return authUserRepo.findAllByCreate(simpleDateFormat.parse("2022-01-01"), simpleDateFormat.parse("2023-09-09"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
