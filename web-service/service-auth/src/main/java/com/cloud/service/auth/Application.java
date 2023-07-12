package com.cloud.service.auth;

import com.cloud.service.auth.remote.DemoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan(basePackages = {"com.cloud"})
@EnableJpaRepositories(basePackages = {"com.cloud"})
@EntityScan("com.cloud")
@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
@EnableTransactionManagement
@EnableFeignClients(clients = {DemoClient.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

