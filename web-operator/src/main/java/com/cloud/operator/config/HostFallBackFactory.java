package com.cloud.operator.config;

import com.cloud.common.bean.ResultsBean;
import feign.hystrix.FallbackFactory;

/**
 * Feign熔断降级处理
 */
public class HostFallBackFactory implements FallbackFactory<ResultsBean<String>> {
    @Override
    public ResultsBean<String> create(Throwable throwable) {
        return ResultsBean.FAIL("服务器调用异常 " + throwable.getMessage());
    }
}
