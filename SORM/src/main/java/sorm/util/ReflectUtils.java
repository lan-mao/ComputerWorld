package sorm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO 封装常用的反射操作
 *
 * @Date 2020/02/18 23:09
 * @Created by lan-mao.top
 */

public class ReflectUtils {
    /**
     * 通过反射调用对应字段的get方法，返回得到的值
     * @param fieldName 要得到的字段名称
     * @param obj 对应表的对象
     * @return get方法得到的值
     */
    public static Object invokeGet( String fieldName, Object obj){
        Class clazz = obj.getClass();
        try {
            //获取类中的公开方法
            Method method = clazz.getDeclaredMethod("get" + StringUtils.toUpperCamelCase(fieldName),null);
            return method.invoke(obj, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过反射调用JavaBean的set方法
     * @param fieldName 需要set的属性名
     * @param obj 对应的对象
     * @param value 要set的值
     */
    public static void invokeSet(String fieldName, Object obj, Object value){
        Class clazz = obj.getClass();
        try {
            Method method = clazz.getDeclaredMethod("set" + StringUtils.toUpperCamelCase(fieldName), value.getClass());
            method.invoke(obj, value);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
