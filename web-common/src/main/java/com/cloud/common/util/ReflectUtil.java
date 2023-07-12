package com.cloud.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 反射工具
 *
 * @author xulijian
 */
public class ReflectUtil {

    /**
     * 反射调用方法
     *
     * @param o    反射对象
     * @param name 方法名
     * @return object
     * @author xulijian
     */
    public static Object invokeMethod(Object o, String name, Object... args) {
        Objects.requireNonNull(o);
        Object result;
        try {
            Method method = o.getClass().getMethod(name);
            result = method.invoke(o, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(o.getClass() + "" + e.getMessage());
        }
        return result;
    }

}
