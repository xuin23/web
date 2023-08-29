package com.cloud.service.auth.config;


import com.cloud.service.auth.remote.DemoClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置
 *
 * @author xuin23
 * @since 20230829
 */
@Configuration
@EnableFeignClients(clients = {DemoClient.class})
public class FeignConfig {
}
