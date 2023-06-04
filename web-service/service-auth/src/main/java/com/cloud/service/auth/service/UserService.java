package com.cloud.service.auth.service;

import com.cloud.service.auth.base.BaseService;
import com.cloud.service.auth.entity.T_User;
import com.cloud.service.auth.repo.UserRepo;
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
public class UserService extends BaseService<T_User, Long> {

    @Resource
    UserRepo userRepo;

    public List<T_User> findAllByCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return userRepo.findAllByCreate(simpleDateFormat.parse("2022-01-01"), simpleDateFormat.parse("2023-09-09"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
