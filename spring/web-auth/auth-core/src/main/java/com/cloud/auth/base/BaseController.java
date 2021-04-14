package com.cloud.auth.base;

import com.cloud.common.bean.ResultBean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 基础Controller 提供简单接口
 *
 * @param <T>
 * @param <ID>
 */
public abstract class BaseController<T, ID extends Serializable> {


    /**
     * 基础service
     */
    @Resource
    private BaseService<T, ID> baseService;


    /**
     *
     *
     * @return ResultBean<List < T>>
     */
    @GetMapping(value = "")
    public ResultBean<List<T>> findAll() {
        return ResultBean.SUCCESS(baseService.findAll());
    }


    @GetMapping(value = "/page")
    public ResultBean<Page<T>> findAllByPage() {
        return ResultBean.SUCCESS(baseService.findAll(0, 10));
    }

    /**
     * 根据ID查询
     *
     * @param id id
     * @return ResultBean<T>
     */
    @GetMapping(value = "/{id}")
    public ResultBean<T> findById(@PathVariable("id") ID id) {
        return ResultBean.SUCCESS(baseService.findById(id));
    }

}
