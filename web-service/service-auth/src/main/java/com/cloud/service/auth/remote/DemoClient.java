package com.cloud.service.auth.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "service-demo")
public interface DemoClient {

    @GetMapping("/random")
    String random();
}
