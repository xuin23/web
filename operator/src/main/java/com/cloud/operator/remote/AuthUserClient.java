package com.cloud.operator.remote;

import com.cloud.auth.common.bean.AuthUserBean;
import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/deleteById/{id}", method = RequestMethod.DELETE)
    public ResultsBean<String> deleteById(@PathVariable("id") Long id);

    /**
     * 创建或更新用户信息
     *
     * @param authUser
     * @return
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/merge", method = RequestMethod.POST)
    public ResultsBean<String> createOrUpdate(@RequestBody AuthUserBean authUser);

    /**
     * 分页查询用户信息
     *
     * @param params
     * @return
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUserQuery/findByPageAll", method = RequestMethod.GET)
    ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestParam Map<String, Object> params);

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

    /**
     * 登录
     *
     * @param username     用户名
     * @param password     密码
     * @param isSecurity   是否使用验证码
     * @param securityCode 验证码
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/operatorLogin/login", method = RequestMethod.POST)
    ResultsBean<Authorization> login(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "isSecurity") Boolean isSecurity,
                                     @RequestParam(value = "securityCode",required = false) String securityCode);
}
