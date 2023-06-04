package com.cloud.service.auth.controller;

import com.cloud.common.common.model.Result;
import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.T_User;
import com.cloud.service.auth.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import java.util.List;

/**
 * 用户 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
@Transactional
public class UserController extends BaseController<T_User, Long> {

    /**
     * RedissonClient
     */
    @Resource
    private RedissonClient redissonClient;

    /**
     * RedisTemplate
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 用户 service
     */
    @Resource
    private UserService userService;

    @Resource
    private ObjectMapper objectMapper;

    @GetMapping(value = "/id/{id}")
    public Result findById(@PathVariable("id") Long id) {

        RLock lock = redissonClient.getLock(this.getClass().toString() + "findById");
        if (!lock.isLocked()) {
            lock.lock();
        }
        List<T_User> allByCreate = userService.findAllByCreate();
        try {
//            if (null != user) {
//                user.setC_name(String.valueOf((int) (Math.random() * 1000)));
//                userService.save(user);
//                redisTemplate.opsForValue().set(String.valueOf(user.getC_id()), objectMapper.writeValueAsString(user));
//                User user1 = objectMapper.readValue(String.valueOf(redisTemplate.opsForValue().get(String.valueOf(user.getC_id()))), User.class);
//                System.out.println(user1);
//            }
//            User user2 = new User();
//            user2.setC_id("admin");
//            user2.setC_name("系统管理员" + (int) (Math.random() * 1000));
//            user2.setC_email("xuin23@outlook.com");
//            user2.setC_password(DigestUtil.encodeByMd5("admin"));
//            userService.save(user2);
            return Result.SUCCESS(allByCreate);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
