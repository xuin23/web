package com.cloud.service.auth.controller;

import com.cloud.common.common.model.Result;
import com.cloud.common.common.util.DigestUtil;
import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.User;
import com.cloud.service.auth.service.AuthUserService;
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

/**
 * 用户 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUser")
@Transactional
public class AuthUserController extends BaseController<User, Long> {

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
    private AuthUserService authUserService;

    @Resource
    private ObjectMapper objectMapper;

    @GetMapping(value = "/id/{id}")
    public Result findById(@PathVariable("id") Long id) {

        RLock lock = redissonClient.getLock(this.getClass().toString() + "findById");
        if (!lock.isLocked()) {
            lock.lock();
        }
        User user = authUserService.findById(id);
        try {
            if (null != user) {
                user.setName(String.valueOf((int) (Math.random() * 1000)));
                authUserService.save(user);
                redisTemplate.opsForValue().set(String.valueOf(user.getId()), objectMapper.writeValueAsString(user));
                User user1 = objectMapper.readValue(String.valueOf(redisTemplate.opsForValue().get(String.valueOf(user.getId()))), User.class);
                System.out.println(user1);
            }
            User user2 = new User();
            user2.setUid("admin");
            user2.setName("系统管理员" + (int) (Math.random() * 1000));
            user2.setEmail("xuin23@outlook.com");
            user2.setPassword(DigestUtil.encodeByMd5("admin"));
            authUserService.save(user2);
            return Result.SUCCESS(authUserService.findAllByCreate());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
