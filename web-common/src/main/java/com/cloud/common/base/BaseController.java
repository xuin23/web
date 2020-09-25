package com.cloud.common.base;

import com.cloud.common.bean.ResultsBean;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * 公共Controller
 * 包含基础的crud操作
 *
 * @param <T> t
 * @author xulijian
 */
@Slf4j
public abstract class BaseController<T> {

    /**
     * 公共 service
     */
    @Autowired
    private BaseService<T> baseService;

    /**
     * 泛型类型
     */
    private final String tName = getTName();

    /**
     * 通过id查询信息
     *
     * @param id id
     * @return ResultsBean<T>
     */
    @GetMapping(value = "/{id}")
    public ResultsBean<T> findById(@PathVariable("id") Long id) {
        log.info("search {} ，id：{}", tName, id);
        T t = baseService.findById(id);
        return ResultsBean.SUCCESS(t);
    }

    /**
     * 通过id删除信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/{id}")
    public ResultsBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("{} delete, id：{}", tName, id);
        baseService.deleteById(id);
        return ResultsBean.SUCCESS();
    }

    /**
     * 添加信息
     *
     * @return ResultsBean<String>
     */
    @PostMapping(value = "")
    public ResultsBean<Long> create(@RequestBody T t) {
        log.info("{} create, {}", tName, t);
        Long id = baseService.create(t);
        return ResultsBean.SUCCESS(id);
    }

    /**
     * 修改信息
     *
     * @param t t
     * @return ResultsBean<String>
     */
    @PutMapping(value = "")
    public ResultsBean<String> updateById(@RequestBody T t) {
        Object id = invokeMethod(t, "getId", new Object());
        if(id instanceof Long){
            log.info("{} update {}", tName, t);
            baseService.modifyById(t,(Long) id);
            return ResultsBean.SUCCESS();
        } else {
            log.error("update {} fail，id: {} is not exist", tName, t);
            return ResultsBean.FAIL(String.format("update %s fail，id: %s is not exist", tName, t));
        }

    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "/list")
    public ResultsBean<PageInfo<Map<String, Object>>> list(@RequestParam Map<String, Object> params) {
        log.info("{} : {}", tName, params);
        PageInfo<Map<String, Object>> page = baseService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "")
    public ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        log.info("{} : {}", tName, params);
        PageInfo<Map<String, Object>> page = baseService.findByPageAll(params);
        return ResultsBean.SUCCESS(page);
    }

    /**
     * 反射调用方法
     *
     * @param o          反射对象
     * @param methodName 方法名
     * @return object
     */
    private Object invokeMethod(Object o, String methodName, Object... args) {
        Objects.requireNonNull(o);
        Object result;
        try {
            Method method = o.getClass().getMethod(methodName);
            result = method.invoke(o, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error("{}", o.getClass(), e);
            throw new RuntimeException(o.getClass() + "" + e.getMessage());
        }
        return result;
    }

    /**
     * 获取泛型 类型
     *
     * @return String
     */
    private String getTName() {
        String fullTypeName = this.getClass().getGenericSuperclass().getTypeName();
        return fullTypeName.substring(fullTypeName.lastIndexOf(".") + 1, fullTypeName.length() - 1);
    }

}
