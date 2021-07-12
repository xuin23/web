package com.cloud.auth.base;

import com.cloud.auth.util.BeanInfoUtil;
import com.cloud.common.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.EntityType;
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
    private JpaRepositoryImplementation<T, ID> repository;


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
    public Page<T> findAll(Map<String, Object> params) {
        int page = 0;
        int size = 10;
        if (null != params) {
            if (params.get("page") instanceof Integer p) {
                page = p;
            }
            if (params.get("size") instanceof Integer s) {
                size = s;
            }
        }
        Specification<T> spec = (root, query, criteriaBuilder) -> {
            EntityType<T> model = root.getModel();
            Class<T> javaType = model.getJavaType();
            Field[] fields = javaType.getFields();

            Path<Date> createTime = root.get("createTime");
            List<Predicate> predicateList = new ArrayList<>() {{
//                add(criteriaBuilder.lessThanOrEqualTo(createTime, new Date()));
//                try {
//                    add(criteriaBuilder.greaterThanOrEqualTo(createTime, new SimpleDateFormat("yyyy-MM-dd").parse("1992-01-01")));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
            }};
            Predicate[] pre = new Predicate[predicateList.size()];
            pre = predicateList.toArray(pre);
            return query.where(pre).getRestriction();
        };
        return repository.findAll(spec, PageRequest.of(page, size));
    }


    /**
     * 保存 or 更新
     *
     * @param t t
     * @return T
     * @author xulijian
     */
    public T save(T t) {
        T result;
        Long id = t.getId();
        if (null == id) {
            result = repository.save(t);
        } else {
            T byId = findById((ID) id);
            if (null != byId) {
                for (PropertyDescriptor propertyDescriptor : BeanUtils.getPropertyDescriptors(t.getClass())) {
                    String name = propertyDescriptor.getName();
                    if (name.equals("class")) {
                        continue;
                    }
                    Object property = BeanInfoUtil.getProperty(t, name);
                    if (null == property) {
                        BeanInfoUtil.setProperty(t, name, BeanInfoUtil.getProperty(byId, name));
                    }
                }
                result = repository.save(t);
            } else {
                throw new RuntimeException("no data," + t.getId());
            }
        }
        return result;
    }


    /**
     * 获取Repository
     *
     * @return JpaRepository<T, ID>
     * @author xulijian
     */
    public abstract JpaRepositoryImplementation<T, ID> getRepository();


    /**
     * 获得指定Repository
     *
     * @author xulijian
     */
    @Autowired
    public void setRepository() {
        repository = getRepository();
    }

}
