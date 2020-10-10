package com.cloud.operator.config;

import com.cloud.common.bean.ResultBean;
import feign.hystrix.FallbackFactory;

/**
 * Feign熔断降级处理
 */
public class HostFallBackFactory implements FallbackFactory<ResultBean<String>> {
    @Override
    public ResultBean<String> create(Throwable throwable) {
        return ResultBean.FAIL("服务器调用异常 " + throwable.getMessage());
    }
}
