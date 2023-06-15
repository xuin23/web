package com.cloud.common.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Bean 工具类
 *
 * @author xulijian
 */
@Slf4j
public class BeanUtil {

    /**
     * 设置bean的某个属性值
     *
     * @param t     bean
     * @param field 字段
     * @param args  参数
     * @author xulijian
     */
    public static <T> void setProperty(T t, String field, Object... args) {
        // 获取bean的某个属性的描述符
        PropertyDescriptor propDesc;
        try {
            propDesc = new PropertyDescriptor(field, t.getClass());
        } catch (IntrospectionException e) {
            log.error("获取class字段失败,{},{},{}", t, field, e.getMessage(), e);
            throw new RuntimeException(e);
        }
        // 写入属性值
        Method writeMethod = propDesc.getWriteMethod();
        try {
            writeMethod.invoke(t, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("方法调用失败,{},{},{}", t, writeMethod.getName(), e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取bean的某个属性值
     *
     * @param t     bean
     * @param field 字段
     * @return Object
     * @author xulijian
     */
    public static <T> Object getProperty(T t, String field) {
        // 获取Bean的某个属性的描述符
        PropertyDescriptor proDescriptor;
        try {
            proDescriptor = new PropertyDescriptor(field, t.getClass());
        } catch (IntrospectionException e) {
            log.error("获取class字段失败,{},{},{}", t, field, e.getMessage(), e);
            throw new RuntimeException(e);
        }
        // 获得用于读取属性值的方法
        Method methodGetUserName = proDescriptor.getReadMethod();
        // 读取属性值
        try {
            return methodGetUserName.invoke(t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("方法调用失败,{},{},{}", t, methodGetUserName.getName(), e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
