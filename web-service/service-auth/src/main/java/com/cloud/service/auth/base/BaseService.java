package com.cloud.service.auth.base;

import com.cloud.common.common.util.BeanUtil;
import com.cloud.frame.spring.jpa.BaseEntity;
import com.cloud.frame.spring.jpa.PageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 基础service(基于SpringBoot Jpa)
 *
 * @param <T>  T
 * @param <ID> ID
 * @author xulijian
 */
@Slf4j
public abstract class BaseService<T extends BaseEntity, ID extends Serializable> {

    /**
     * JpaRepository JpaSpecificationExecutor
     */
    @Autowired
    JpaRepositoryImplementation<T, ID> repository;


    /**
     * 获取所有
     *
     * @return List<T>
     * @author xulijian
     */
    public List<T> findAll() {
        return repository.findAll();
    }

    /**
     * 根据Id获取
     *
     * @return List<T>
     * @author xulijian
     */
    public T findById(ID id) {
        Optional<T> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return byId.get();
    }

    /**
     * 分页查询
     *
     * @return Page<T>
     * @author xulijian
     */
    public Page<T> findAll(PageParam params) {
        return repository.findAll(
                (root, query, criteriaBuilder) -> query.where(generateWhere(params, root, criteriaBuilder)).getRestriction(),
                PageRequest.of(params.getPageNumber(), params.getPageSize(), Sort.by(Sort.Order.asc("createTime")))
        );
    }

    /**
     * 生成where条件
     *
     * @param params          查询条件
     * @param root            Root<T>
     * @param criteriaBuilder SQL生成Builder
     * @return Predicate[]
     * @author xulijian
     */
    private Predicate[] generateWhere(PageParam params, Root<T> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();

        Map<String, Object> queryParams = params.getQueryParams();
        if (null != queryParams) {
            queryParams.forEach((k, v) -> {
                Path<Object> objectPath = root.get(k);
                Predicate equal;
                if (objectPath.getJavaType().equals(Date.class) && v instanceof Long timestamp) {
                    equal = criteriaBuilder.equal(objectPath, new Date(timestamp));
                } else {
                    equal = criteriaBuilder.equal(objectPath, v);
                }
                predicateList.add(equal);
            });
        }

        return predicateList.toArray(new Predicate[0]);
    }

    /**
     * 保存 or 更新
     *
     * @param t t
     * @return T
     * @author xulijian
     */
    public T save(T t) {
        Long id = t.getPk();
        if (null != id) {
            T byId = findById((ID) id);
            if (null == byId)
                throw new RuntimeException("No data," + t.getPk());

            for (PropertyDescriptor propertyDescriptor : BeanUtils.getPropertyDescriptors(t.getClass())) {
                String name = propertyDescriptor.getName();
                if (name.equals("class")) {
                    continue;
                }
                Object property = BeanUtil.getProperty(t, name);
                if (null == property) {
                    BeanUtil.setProperty(t, name, BeanUtil.getProperty(byId, name));
                }
            }
        }
        return repository.save(t);
    }


//    /**
//     * 获取Repository
//     *
//     * @return JpaRepository<T, ID>
//     * @author xulijian
//     */
//    public abstract JpaRepositoryImplementation<T, ID> getRepository();
//
//
//    /**
//     * 获得指定Repository
//     *
//     * @author xulijian
//     */
//    @Autowired
//    public void setRepository() {
//        repository = getRepository();
//    }


    /**
     * 判断并合并属性值
     *
     * @param sourceField 数据源属性
     * @param targetField 目标源属性
     * @param source      数据源
     * @param target      目标源
     * @return Boolean是否合并
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
