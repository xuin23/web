package com.cloud.common.base;

import com.cloud.common.bean.ResultBean;
import com.cloud.common.utils.ReflectUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 通用Controller
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
    public ResultBean<T> findById(@PathVariable("id") Long id) {
        log.info("search {} ，id：{}", tName, id);
        T t = baseService.findById(id);
        return ResultBean.SUCCESS(t);
    }

    /**
     * 通过id删除信息
     *
     * @param id id
     * @return ResultsBean<String>
     */
    @DeleteMapping(value = "/{id}")
    public ResultBean<String> deleteById(@PathVariable("id") Long id) {
        log.info("{} delete, id：{}", tName, id);
        baseService.deleteById(id);
        return ResultBean.SUCCESS();
    }

    /**
     * 添加信息
     *
     * @return ResultsBean<String>
     */
    @PostMapping(value = "")
    public ResultBean<Long> create(@RequestBody T t) {
        log.info("{} create, {}", tName, t);
        Long id = baseService.create(t);
        return ResultBean.SUCCESS(id);
    }

    /**
     * 修改信息
     *
     * @param t t
     * @return ResultsBean<String>
     */
    @PutMapping(value = "")
    public ResultBean<String> updateById(@RequestBody T t) {
        Object id = ReflectUtil.invokeMethod(t, "getId", new Object());
        if (id instanceof Long) {
            log.info("{} update {}", tName, t);
            int i = baseService.modifyById(t, (Long) id);
            if (i == 0) {
                log.error("update {} fail，nothing changed.", tName);
                return ResultBean.FAIL(String.format("update %s fail，nothing changed.", tName));
            }
            return ResultBean.SUCCESS();
        } else {
            log.error("update {} fail，id: {} is not exist", tName, t);
            return ResultBean.FAIL(String.format("update %s fail，id: %s is not exist", tName, t));
        }

    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "/list")
    public ResultBean<PageInfo<Map<String, Object>>> list(@RequestParam Map<String, Object> params) {
        log.info("{} : {}", tName, params);
        PageInfo<Map<String, Object>> page = baseService.findByPageAll(params);
        return ResultBean.SUCCESS(page);
    }

    /**
     * 列表查询用户信息
     *
     * @param params 参数
     * @return ResultsBean
     */
    @GetMapping(value = "")
    public ResultBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestBody Map<String, Object> params) {
        log.info("{} : {}", tName, params);
        PageInfo<Map<String, Object>> page = baseService.findByPageAll(params);
        return ResultBean.SUCCESS(page);
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
