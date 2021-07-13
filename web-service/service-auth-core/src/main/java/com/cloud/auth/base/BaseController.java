package com.cloud.auth.base;

import com.cloud.auth.entity.PageParam;
import com.cloud.common.bean.Result;
import com.cloud.common.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * 基础Controller 提供简单接口
 *
 * @param <T>
 * @param <ID>
 * @author xulijian
 */
@Slf4j
public abstract class BaseController<T extends BaseEntity, ID extends Serializable> {

    /**
     * 基础service
     */
    @Resource
    private BaseService<T, ID> baseService;


    /**
     * @return ResultBean<List < T>>
     * @author xulijian
     */
    @GetMapping(value = "")
    public Result<List<T>> findAll() {
        log.info("findAll");
        return Result.SUCCESS(baseService.findAll());
    }

    /**
     * 分页查询
     *
     * @return ResultBean<Page < T>>
     * @author xulijian
     */
    @PostMapping(value = "/page")
    public Result<Page<T>> findAllByPage(@RequestBody(required = false) PageParam param) {
        log.info("findAllByPage ,{}", param);
        return Result.SUCCESS(baseService.findAll(param));
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return ResultBean<T>
     * @author xulijian
     */
    @GetMapping(value = "/id/{id}")
    public Result<T> findById(@PathVariable("id") ID id) {
        return Result.SUCCESS(baseService.findById(id));
    }

    /**
     * 保存 or 更新
     *
     * @param t t
     * @return T
     * @author xulijian
     */
    @Transactional(rollbackOn = Exception.class)
    @PostMapping(value = "/save")
    public Result<T> save(@RequestBody T t) {
        log.info("save,{}", t);
        return Result.SUCCESS(baseService.save(t));
    }
}
