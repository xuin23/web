package com.cloud.operator.remote;

import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 邮箱客户端
 */
@FeignClient(value = FeignClientConstants.SMS_EUREKA_SERVER_INSTANCE_CORE)
public interface EmailClient {

    /**
     * 发送邮箱验证码
     * @param username 用户名
     * @return ResultsBean<String>
     */
    @RequestMapping(path = FeignClientConstants.SMS_APPLICATION_NAME_CODE + "/email/sendEmail", method = RequestMethod.POST)
    public ResultsBean<String> sendEmail(@RequestParam("username") String username);

}
