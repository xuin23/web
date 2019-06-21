package com.cloud.operator.remote;

import com.cloud.auth.common.bean.AuthUserBean;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户客户端
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE)
public interface AuthUserClient {

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/deleteById/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id);

    /**
     * 创建或更新用户信息
     *
     * @param authUser
     * @return
     */
    @PostMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/createOrUpdate")
    public ResultsBean<String> createOrUpdate(@RequestBody AuthUserBean authUser);
}
