package com.cloud.common.base;

import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
public abstract class BaseController<T> {

    @Autowired
    private BaseService<T> baseService;

    /**
     * 通过id查询用户信息
     *
     * @param id id
     * @return ResultsBean<AuthUser>
     */
    @GetMapping(value = "/{id}")
    public ResultsBean<T> findById(@PathVariable("id") Long id) {
        T t = baseService.findById(id);
        return ResultsBean.SUCCESS(t);
    }

    /**
     * 通过id删除用户信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("用户信息删除 ID={}", id);
        baseService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 添加用户信息
     *
     * @return ResultsBean<String>
     */
    @PostMapping(value = "")
    public ResultsBean<String> create(@RequestBody T t) {
        log.info("新建{}, {}", t.getClass(), t);
        baseService.create(t);
        return ResultsBean.SUCCESS();
    }

    /**
     * 修改用户信息
     *
     * @return ResultsBean<String>
     */
    @PutMapping(value = "")
    public ResultsBean<String> updateById(@RequestBody T t) {
        Long id = null;
        try {
            Method method = t.getClass().getMethod("getId");
            id = (Long) method.invoke(t, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        if (null != id) {
            log.info("{} 更新 {}", t.getClass(), t);
            baseService.modifyById(t, id);
            return ResultsBean.SUCCESS();
        } else {
            log.error("更新失败，不存在id，{}", t);
            return ResultsBean.FAIL("更新失败，不存在id");
        }

    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        PageInfo<Map<String, Object>> page = baseService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

}
