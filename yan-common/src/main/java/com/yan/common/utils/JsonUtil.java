package com.yan.common.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonUtil {

    public static String objectToString(Object obj) {
        Class<?> clazz = obj.getClass();
        Map<String, Object> fields = new LinkedHashMap<>();

        try {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                fields.put(fieldName, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("{");
        for (Iterator<Map.Entry<String, Object>> iterator = fields.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Object> entry = iterator.next();
            String fieldName = entry.getKey();
            Object value = entry.getValue();
            sb.append(fieldName).append("=").append(getValueAsString(value));
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String getValueAsString(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
