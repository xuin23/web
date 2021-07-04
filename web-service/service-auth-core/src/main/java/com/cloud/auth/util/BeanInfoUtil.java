package com.cloud.auth.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {

    /**
     * 设置bean的某个属性值
     *
     * @param t     bean
     * @param field 字段
     * @param args  参数
     * @throws Exception 异常
     * @author xulijian
     */
    public static <T> void setProperty(T t, String field, Object... args) throws Exception {
        // 获取bean的某个属性的描述符
        PropertyDescriptor propDesc = new PropertyDescriptor(field, t.getClass());
        // 写入属性值
        propDesc.getWriteMethod().invoke(t, args);
    }


    /**
     * 获取bean的某个属性值
     *
     * @param t     bean
     * @param field 字段
     * @return Object
     * @throws Exception 异常
     * @author xulijian
     */
    public static <T> Object getProperty(T t, String field) throws Exception {
        // 获取Bean的某个属性的描述符
        PropertyDescriptor proDescriptor = new PropertyDescriptor(field, t.getClass());
        // 获得用于读取属性值的方法
        Method methodGetUserName = proDescriptor.getReadMethod();
        // 读取属性值
        return methodGetUserName.invoke(t);
    }
}
