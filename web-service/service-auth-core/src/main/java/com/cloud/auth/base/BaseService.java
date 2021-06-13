package com.cloud.auth.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 基础service(基于SpringBoot Jpa)
 *
 * @param <T>  T
 * @param <ID> ID
 * @author xulijian
 */
public abstract class BaseService<T, ID extends Serializable> {

    /**
     * JpaRepository
     */
    private JpaRepository<T, ID> repository;


    /**
     * JpaSpecificationExecutor
     */
    private JpaSpecificationExecutor<T> specification;


    /**
     * 获取所有
     *
     * @return List<T>
     */
    public List<T> findAll() {
        return repository.findAll();
    }

    /**
     * 根据Id获取
     *
     * @return List<T>
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
     * @param page 页码
     * @param size 长度
     * @return Page<T>
     */
    public Page<T> findAll(int page, int size) {
        Specification<T> spec = (Specification<T>) (root, query, criteriaBuilder) -> {

            Path<Date> createTime = root.get("createTime");
            List<Predicate> predicateList = new ArrayList<>() {{
                add(criteriaBuilder.lessThanOrEqualTo(createTime, new Date()));
                try {
                    add(criteriaBuilder.greaterThanOrEqualTo(createTime, new SimpleDateFormat("yyyy-MM-dd").parse("1992-01-01")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }};
            Predicate[] pre = new Predicate[predicateList.size()];
            pre = predicateList.toArray(pre);
            return query.where(pre).getRestriction();
        };
        return specification.findAll(spec, PageRequest.of(page, size));
    }


    /**
     * 保存
     *
     * @param t t
     * @return List<T>
     */
    public T save(T t) {
        return repository.save(t);
    }

    /**
     * 保存
     *
     * @param t t
     * @return List<T>
     */
    public List<T> findAll(T t) {
        return repository.findAll(Example.of(t));
    }


    /**
     * 获取Repository
     *
     * @return JpaRepository<T, ID>
     */
    public abstract JpaRepository<T, ID> getRepository();

    /**
     * 获取Repository
     *
     * @return JpaRepository<T, ID>
     */
    public abstract JpaSpecificationExecutor<T> getSpecificationExecutor();


    @Autowired
    public void setRepository() {
        repository = getRepository();
    }

    @Autowired
    public void setSpecification() {
        specification = getSpecificationExecutor();
    }

}
