package com.cloud.common.base;

/**
 * Service接口
 *
 * @param <T> t
 * @author xulijian
 */
public interface IService<T> {

    /**
     * 创建方法
     *
     * @param t 实体类
     * @return 主键
     */
    Long create(T t);

    /**
     * 根据Id修改
     *
     * @param t  实体类
     * @param id id
     */
    int modifyById(T t, Long id);

    /**
     * 根据Id删除
     *
     * @param id id
     * @return int
     */
    int deleteById(Long id);

    /**
     * 根据Id查询
     *
     * @param id id
     * @return T
     */
    T findById(Long id);
}
