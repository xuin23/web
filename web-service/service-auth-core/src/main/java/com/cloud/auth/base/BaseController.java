package com.cloud.auth.base;

import com.cloud.common.bean.ResultBean;
import com.cloud.common.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    public ResultBean<List<T>> findAll() {
        log.info("findAll");
        return ResultBean.SUCCESS(baseService.findAll());
    }

    /**
     * 分页查询
     *
     * @return ResultBean<Page < T>>
     * @author xulijian
     */
    @GetMapping(value = "/page")
    public ResultBean<Page<T>> findAllByPage(@RequestParam Map<String, Object> param) {
        log.info("findAllByPage ,{}", param);
        return ResultBean.SUCCESS(baseService.findAll(param));
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return ResultBean<T>
     * @author xulijian
     */
    @GetMapping(value = "/id/{id}")
    public ResultBean<T> findById(@PathVariable("id") ID id) {
        return ResultBean.SUCCESS(baseService.findById(id));
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
    public ResultBean<T> save(@RequestBody T t) {
        log.info("save,{}", t);
        return ResultBean.SUCCESS(baseService.save(t));
    }


    /**
     * 判断并合并属性值
     *
     * @param sourceField 数据源属性
     * @param targetField 目标源属性
     * @param source      数据源
     * @param target      目标源
     * @return Boolean：是否合并
     * @author xulijian
     */
    private static boolean judgeAssign(Field sourceField, Field targetField, Object source, Object target) {
        try {
            if (sourceField.getName().equalsIgnoreCase(targetField.getName()) && sourceField.getType().getTypeName().equals(targetField.getType().getTypeName())) {
                sourceField.setAccessible(true);
                Object obj = sourceField.get(source);
                //集合类型非空判断
                if (obj instanceof Collection<?> newValue) {
                    if (newValue.size() <= 0)
                        return true;
                }
                //数据类型非空判断
                if (obj != null) {
                    targetField.setAccessible(true);
                    targetField.set(target, obj);
                }
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
