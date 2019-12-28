package com.cloud.common.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公共Mapper
 *
 * @param <T> t
 * @author xulijian
 */
public interface BaseMapper<T> {

    /**
     * 根据id查询
     *
     * @param id id
     * @return T
     */
    T findById(Long id);

    /**
     * 插入方法
     *
     * @param t t
     * @return id
     */
    Long insert(T t);


    /**
     * 根据id删除
     *
     * @param id id
     */
    int deleteById(Long id);


    /**
     * 根据id 更新
     *
     * @param t t
     * @return int
     */
    int updateById(T t);


    /**
     * 列表查询
     *
     * @param params 参数
     * @return 分页查询结果
     */
    List<Map<String, Object>> findByPageAll(@Param("params") Map<String, Object> params);
}
