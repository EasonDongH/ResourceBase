package com.easondongh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author EasonDongH
 */
public class JsonUtil {

    /**
     *  Java对象转Json字符串
     * @param obj
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public static <T> String javaBeanToJson(T obj) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        String str = objectMapper.writeValueAsString(obj);
        return str;
    }

    /**
     *  字符串转Java对象
     * @param str
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T jsonToJavaBean(String str, Class<T> type) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();
        return objectMapper.readValue(str, type);
    }

    /**
     *  字符串转JavaBean集合对象
     * @param str
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T jsonToJavaBean(String str, TypeReference<T> type) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();
        return objectMapper.readValue(str, type);
    }
}
