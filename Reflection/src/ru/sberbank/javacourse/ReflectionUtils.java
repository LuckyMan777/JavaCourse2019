package ru.sberbank.javacourse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {
    public static List<String> getMethodName(Object o) {
        Class<?> clazz = o.getClass();
        List<String> names = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            names.add(method.getName());
        }
        return names;
    }

    public static Map<String, Object> getAllFieldValues(Object o) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> superclass = o.getClass();
        while (superclass != null) {
            for (Field field : superclass.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(o);
                map.put(field.toString(), value);
            }
            superclass = superclass.getSuperclass();
        }
        return map;
    }

    public void invoke(Object o, String method) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Method m = clazz.getDeclaredMethod(method);
        m.setAccessible(true);
        m.invoke(o);
    }
}
