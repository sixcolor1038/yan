package com.yan.common.utils;
import org.springframework.beans.BeanUtils;

public class ConverterUtils {

    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T targetInstance = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, targetInstance);
            return targetInstance;
        } catch (Exception e) {
            throw new RuntimeException("转换失败！", e);
        }
    }
}
