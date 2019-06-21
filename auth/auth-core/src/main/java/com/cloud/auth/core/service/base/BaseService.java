package com.cloud.auth.core.service.base;

import com.cloud.auth.mapper.base.BaseMapper;
import com.cloud.common.constant.CommonConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 公共 service 接口
 *
 * @param <T>
 */
@Slf4j
@Component
public class BaseService<T> {

    //@Resource
    // 使用Resoure会出错，执行MyBatis时会找baseMapper.xml下的Sql
    @Autowired
    private BaseMapper<T> baseMapper;

    /**
     * 创建
     *
     * @param t
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(T t) {
        baseMapper.insert(t);
    }

    /**
     * 根据id修改
     *
     * @param t
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int modifyById(T t, Long id) {
        int i = 0;
        if (id != null) {
            i = baseMapper.updateById(t);
        }
        return i;
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
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
     * @param id
     * @return
     */
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
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PageInfo<Map<String, Object>> findByPageAll(Map<String, Object> params) {
        //页码
        int pageNum = params.get("pageNum") == null ? 1 : Integer.parseInt(params.get("pageNum").toString());
        //每页显示数量
        int pageSize = params.get("pageSize") == null ? CommonConstants.DEFALT_PAGE_SIZE : Integer.parseInt(params.get("pageSize").toString());
        // 设置页属性
        PageHelper.startPage(pageNum, pageSize, true);
        // 查询数据
        List<Map<String, Object>> list = baseMapper.findByPageAll(params);
        // 用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> page = new PageInfo<>(list);
        return page;
    }

}
