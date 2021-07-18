package com.cloud.common.entity;

import lombok.Data;

import java.util.Map;

@Data
public class PageParam {

    private int pageNumber = 0;

    private int pageSize = 10;

    private Map<String, Object> queryParams;

}
