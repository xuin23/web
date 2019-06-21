package com.cloud.operator.remote.query;

import com.cloud.auth.common.bean.AuthUserBean;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 用户查询客户端
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE)
public interface AuthUserQueryClient {

    /**
     * 分页查询用户信息
     *
     * @param params
     * @return
     */
    @GetMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findByPageAll")
    ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestParam Map<String, Object> params);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findById/{id}")
    ResultsBean<AuthUserBean> findById(@PathVariable("id") Long id);

    /**
     * 根据姓名查询用户信息
     *
     * @param username
     * @return
     */
    @GetMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findByUserName")
    ResultsBean<AuthUserBean> findByUserName(@RequestParam("username") String username);
}
