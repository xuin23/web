package com.cloud.auth.controller.auth;

import com.cloud.auth.base.BaseController;
import com.cloud.auth.service.auth.AuthUserService;
import com.cloud.auth.entity.AuthUser;
import com.cloud.common.bean.Result;
import lombok.extern.slf4j.Slf4j;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * 用户 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUser")
public class AuthUserController extends BaseController<AuthUser, Long> {

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

    @GetMapping(value = "/id/{id}")
    public Result<AuthUser> findById(@PathVariable("id") Long id) {

        RLock lock = redissonClient.getLock(this.getClass().toString() + "findById");
        if (!lock.isLocked()) {
            lock.lock();
        }
        AuthUser authUser = authUserService.findById(id);
        try {
            if (null != authUser) {
                authUser.setRealname(String.valueOf((int) (Math.random() * 1000)));
                authUserService.save(authUser);
                redisTemplate.opsForValue().set(String.valueOf(authUser.getId()), authUser);
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            return Result.FAIL(e.getMessage());
        } finally {
            lock.unlock();
        }
        AuthUser authUser1 = (AuthUser) redisTemplate.opsForValue().get(String.valueOf(authUser.getId()));
        return Result.SUCCESS(authUser1);
    }
}
