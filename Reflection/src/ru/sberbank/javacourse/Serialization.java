package ru.sberbank.javacourse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class Serialization {
    private static JsonArray serializeCollection(Collection c) throws IllegalAccessException {
        JsonArray json = new JsonArray();
        for (Object o : c) {
            JsonObject child;
            if (isPrimitiveOrPrimitiveWrapperOrString(o.getClass()))
                addSimpleObjectToJsonArray(json, o);
            else {
                child = serializeToJson(o);
                json.add(child);
            }
        }
        return json;
    }

    private static void addSimpleObjectToJsonArray(JsonArray array, Object obj) {
        if (obj instanceof Boolean) {
            array.add((Boolean) obj);
        }
        if (obj instanceof Number) {
            array.add((Number) obj);
        }
        if (obj instanceof String) {
            array.add((String) obj);
        }
        if (obj instanceof Character) {
            array.add((Character) obj);
        }
    }

    private static boolean isPrimitiveOrPrimitiveWrapperOrString(Class<?> type) {
        return (type.isPrimitive() && type != void.class) ||
                type == Double.class || type == Float.class || type == Long.class ||
                type == Integer.class || type == Short.class || type == Character.class ||
                type == Byte.class || type == Boolean.class || type == String.class ||
                type.isAssignableFrom(String.class);

    }

    private static void serializeObjectOfClass(JsonObject json, Class<?> clazz, Object obj) throws IllegalAccessException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();
            if (isPrimitiveOrPrimitiveWrapperOrString(type)) {
                json.add(name, gson.toJsonTree(field.get(obj), type));
                continue;
            }
            if (field.get(obj) instanceof Collection) {
                json.add(name, serializeCollection((Collection) field.get(obj)));
                continue;
            }
            json.add(name, serializeToJson(field.get(obj)));
        }
    }


    private static JsonObject serializeToJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        JsonObject json = new JsonObject();
        while (clazz != Object.class) {
            serializeObjectOfClass(json, clazz, obj);
            clazz = clazz.getSuperclass();
        }
        return json;
    }

    public static void serializeIntoFile(Object obj, String fname) throws IllegalAccessException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject json = serializeToJson(obj);
        String str = gson.toJson(json);

        Path path = Paths.get(fname);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(str);
        }
    }
}
