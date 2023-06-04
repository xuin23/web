package com.cloud.service.auth.service;

import com.cloud.service.auth.base.BaseService;
import com.cloud.service.auth.entity.User;
import com.cloud.service.auth.repo.AuthUserRepo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 用户 service
 *
 * @author xulijian
 */
@Service
public class UserService extends BaseService<User, Long> {

    @Resource
    AuthUserRepo authUserRepo;

    public List<User> findAllByCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return authUserRepo.findAllByCreate(simpleDateFormat.parse("2022-01-01"), simpleDateFormat.parse("2023-09-09"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
