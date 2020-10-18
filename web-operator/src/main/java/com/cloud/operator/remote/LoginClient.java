package com.cloud.operator.remote;

import com.cloud.auth.common.bean.Authorization;
import com.cloud.common.bean.ResultBean;
import com.cloud.common.constant.FeignClientConstants;
import com.cloud.operator.config.HostFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录客户端
 * 
 * @author xulijian
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE, fallbackFactory = HostFallBackFactory.class)
public interface LoginClient {

    /**
     * 登录
     *
     * @param username     用户名
     * @param password     密码
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/login", method = RequestMethod.POST)
    ResultBean<Authorization> login(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "isSecurity") Boolean isSecurity,
                                    @RequestParam(value = "securityCode", required = false) String securityCode);

    /**
     * 注册
     *
     * @param username     用户名
     * @param securityCode 验证码
     * @return ResultsBean<String>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/register", method = RequestMethod.POST)
    ResultBean<Authorization> register(@RequestParam(value = "username") String username,
                                       @RequestParam(value = "securityCode") String securityCode);


}
