package com.cloud.service.auth.controller.auth;

import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.service.auth.AuthUserService;
import com.cloud.entity.AuthUser;
import com.cloud.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private AuthUserService authUserService;

    @GetMapping(value = "/{id}")
    public ResultBean<AuthUser> findById(@PathVariable("id") Long id) {

        RLock lock = redissonClient.getLock(this.getClass().toString() + "findById");
        if (!lock.isLocked()) {
            lock.lock();
        }
        try {
            AuthUser authUser = authUserService.findById(id);
            if (null != authUser) {
                log.info("{}", authUser);
                Thread.sleep(5000);

                authUser.setRealname(String.valueOf((int) (Math.random() * 1000)));
                authUserService.save(authUser);
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            return ResultBean.FAIL(e.getMessage());
        } finally {
            lock.unlock();
        }
        return ResultBean.SUCCESS(authUserService.findById(id));
    }
}
