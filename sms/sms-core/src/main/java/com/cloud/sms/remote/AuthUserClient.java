package com.cloud.sms.remote;

import com.cloud.auth.common.bean.AuthUserBean;
import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * 用户客户端
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE)
public interface AuthUserClient {


    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findById/{id}", method = RequestMethod.GET)
    ResultsBean<AuthUserBean> findById(@PathVariable("id") Long id);

    /**
     * 根据姓名查询用户信息
     *
     * @param username
     * @return
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findByUserName", method = RequestMethod.GET)
    ResultsBean<AuthUserBean> findByUserName(@RequestParam("username") String username);


}
