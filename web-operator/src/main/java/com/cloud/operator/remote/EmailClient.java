package com.cloud.operator.remote;

import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import com.cloud.operator.config.HostFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 邮箱客户端
 */
@FeignClient(value = FeignClientConstants.MESSAGE_EUREKA_SERVER_INSTANCE_CORE, fallbackFactory = HostFallBackFactory.class)
public interface EmailClient {

    /**
     * 发送邮箱验证码
     *
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @RequestMapping(path = FeignClientConstants.MESSAGE_APPLICATION_NAME_CODE + "/email/sendEmail", method = RequestMethod.POST)
    ResultsBean<String> sendEmail(@RequestParam("username") String username);

}
