package com.cloud.frame.spring.jpa;

import lombok.Data;

import java.util.Map;

/**
 * 分页参数
 *
 * @author xulijian
 */
@Data
public class PageParam {

    private int pageNumber = 0;

    private int pageSize = 10;

    private Map<String, Object> queryParams;

}
