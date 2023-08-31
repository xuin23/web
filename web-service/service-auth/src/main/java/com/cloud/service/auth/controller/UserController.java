package com.cloud.service.auth.controller;

import com.cloud.common.model.Result;
import com.cloud.frame.spring.common.Timing;
import com.cloud.frame.spring.redis.RedisLock;
import com.cloud.service.auth.base.BaseController;
import com.cloud.service.auth.entity.T_User;
import com.cloud.service.auth.producer.KafkaProducer;
import com.cloud.service.auth.remote.DemoClient;
import com.cloud.service.auth.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private DemoClient demoClient;

    @Resource
    private KafkaProducer kafkaProducer;

    @Timing
    @RedisLock
    @GetMapping
    public Result demo() {
        kafkaProducer.sendMessage("web-log", "a" + Math.random());
        return Result.SUCCESS(demoClient.random());
    }

    @GetMapping(value = "/id/{id}")
    public Result findById(@PathVariable("id") Long id) {

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
        }
    }
}
