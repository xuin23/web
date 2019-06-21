package com.cloud.auth.mapper.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公共Mapper
 *
 * @param <T>
 */
public interface BaseMapper<T> {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public T selectById(Long id);

    /**
     * 插入方法
     *
     * @param t
     * @return
     */
    public int insert(T t);


    /**
     * 根据id删除
     *
     * @param id
     */
    public int deleteById(Long id);


    /**
     * 根据id 更新
     *
     * @param t
     * @return
     */
    public int updateById(T t);


    /**
     * 列表查询
     *
     * @param params
     * @return 分页查询结果
     */
    public List<Map<String, Object>> findByPageAll(@Param("params") Map<String, Object> params);
}
