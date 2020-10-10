package com.cloud.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 公共 service 抽象类（对应数据库表格）
 *
 * @param <T> t
 * @author xulijian
 */
@Component
public abstract class BaseService<T> implements IService<T> {

    /**
     * 基础Mapper
     * 
     * 使用Resoure会出错，MyBatis会找baseMapper.xml下的Sql
     */
    @Autowired
    private BaseMapper<T> baseMapper;

    /**
     * 创建
     *
     * @param t t
     * @return id 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long create(T t) {
        return baseMapper.insert(t);
    }

    /**
     * 根据id修改
     *
     * @param t  t
     * @param id id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int modifyById(T t, Long id) {
        int i = 0;
        if (null != id) {
            i = baseMapper.updateById(t);
        }
        return i;
    }

    /**
     * 通过id删除
     *
     * @param id id
     * @return int
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteById(Long id) {
        int i = 0;
        if (null != id) {
            i = baseMapper.deleteById(id);
        }
        return i;
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return int
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        return baseMapper.findById(id);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return PageInfo<Map < String, Object>>
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PageInfo<Map<String, Object>> findByPageAll(Map<String, Object> params) {
        // 页码
        int pageNum = params.get("pageNum") == null ? 1 : Integer.parseInt(params.get("pageNum").toString());
        // 每页显示数量
        int pageSize = params.get("pageSize") == null ? 10
                : Integer.parseInt(params.get("pageSize").toString());
        // 设置页属性
        PageHelper.startPage(pageNum, pageSize, true);
        // 查询数据
        List<Map<String, Object>> list = baseMapper.findByPageAll(params);
        // 用PageInfo对结果进行包装
        return new PageInfo<>(list);
    }

}
