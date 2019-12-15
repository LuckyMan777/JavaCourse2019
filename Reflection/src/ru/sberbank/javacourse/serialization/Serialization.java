package ru.sberbank.javacourse.serialization;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.sberbank.javacourse.ReflectionUtils.getAllFieldValues;

public class Serialization {

    private static final int INDENT = 4;

    public static String serialize(Object obj) {
        return serializeObject(obj, 0);
    }

    private static String getNSpaces(int n) {
        return IntStream.range(0, n).mapToObj(i -> " ").collect(Collectors.joining(""));
    }

    private static String serializeObject(Object obj, int shift) {
        if (obj == null) {
            return "null";
        }
        if (Collection.class.isAssignableFrom(obj.getClass())) {
            return serializeCollection((Collection) obj, shift + 1);
        }
        if (Map.class.isAssignableFrom(obj.getClass())) {
            return serializeMap((Map) obj, shift + 1);
        }
        if (isPrimitiveOrPrimitiveWrapperOrString(obj.getClass())) {
            return "\"" + obj.toString() + "\"";
        }
        return serializeMap(getAllFieldValues(obj), shift + 1);

    }

    private static String serializeMap(Map<?, ?> map, int shift) {
        StringBuilder res = new StringBuilder(getNSpaces((shift - 1) * INDENT) + "{\n");
        for (Object o : map.keySet()) {
            res.append(getNSpaces(shift * INDENT)).append("\"").append(o.toString()).append("\": ");
            res.append(serializeObject(map.get(o), shift));
            if (map.get(o) == null || isPrimitiveOrPrimitiveWrapperOrString(map.get(o).getClass())) {
                res.append(",\n");
            } else {
                res.replace(res.length() - 1, res.length(), ",");
                res.append("\n");
            }
        }
        res.replace(res.length() - 2, res.length(), "\n");
        res.append(getNSpaces((shift - 1) * INDENT)).append("}\n");
        return res.toString();
    }

    private static String serializeCollection(Collection<?> c, int shift) {
        StringBuilder res = new StringBuilder(getNSpaces((shift - 1) * INDENT) + "[\n");
        for (Object o : c) {
            res.append(getNSpaces(shift * INDENT)).append(serializeObject(o, shift + 1)).append(",\n");
        }
        res.replace(res.length() - 2, res.length(), "\n");
        res.append(getNSpaces((shift - 1) * INDENT)).append("]\n");
        return res.toString();
    }

    private static boolean isPrimitiveOrPrimitiveWrapperOrString(Class<?> type) {
        Set<Class<?>> simples = new HashSet<>();
        simples.add(Double.class);
        simples.add(Float.class);
        simples.add(Long.class);
        simples.add(Integer.class);
        simples.add(Short.class);
        simples.add(Character.class);
        simples.add(Byte.class);
        simples.add(Boolean.class);
        simples.add(String.class);

        return (type.isPrimitive() && type != void.class) ||
                simples.contains(type) ||
                type.isAssignableFrom(String.class);

    }
}
