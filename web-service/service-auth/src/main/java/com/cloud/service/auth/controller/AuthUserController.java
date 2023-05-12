package com.cloud.service.auth.controller;

import com.cloud.common.common.model.Result;
import com.cloud.common.common.util.DigestUtil;
import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.AuthUser;
import com.cloud.service.auth.service.AuthUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户 Controller
 * 
 * @author xulijian
 */
@Slf4j
@RestController
@RequestMapping(value = "/authUser")
@Transactional
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

    @Resource
    RestHighLevelClient restHighLevelClient;

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
        AuthUser authUser = authUserService.findById(id);
        try {
            if (null != authUser) {
                authUser.setName(String.valueOf((int) (Math.random() * 1000)));
                authUserService.save(authUser);
                redisTemplate.opsForValue().set(String.valueOf(authUser.getId()), objectMapper.writeValueAsString(authUser));
                AuthUser authUser1 = objectMapper.readValue(String.valueOf(redisTemplate.opsForValue().get(String.valueOf(authUser.getId()))), AuthUser.class);
                System.out.println(authUser1);
            }
            AuthUser authUser2 = new AuthUser();
            authUser2.setUid("admin");
            authUser2.setName("系统管理员" + (int) (Math.random() * 1000));
            authUser2.setEmail("xuin23@outlook.com");
            authUser2.setPassword(DigestUtil.encodeByMd5("admin"));
            authUserService.save(authUser2);
            return Result.SUCCESS(authUserService.findAllByCreate());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            return Result.FAIL(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
