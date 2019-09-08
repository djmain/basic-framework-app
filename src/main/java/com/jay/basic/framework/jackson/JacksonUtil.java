package com.jay.basic.framework.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

/**
 * created by Jay on 2019/9/8
 */
public class JacksonUtil
{
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Object -> String
     */
    public static String write(Object object) throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * String -> Object
     *
     * @param
     */
    public static <T> T read(String content, Class<T> clazz) throws IOException
    {
        return objectMapper.readValue(content, clazz);
    }

    /**
     * String -> Object（返回结果带泛型）
     */
    public static <T> T read(String content, TypeReference typeReference) throws IOException
    {
        return objectMapper.readValue(content, typeReference);
    }


    public static void main(String[] args) throws Exception
    {
        Father father = new Father();
        father.setName("Jack");
        System.out.println(write(father)); //{"name":"Jack"}
        String content = "{\"name\":\"DJ\"}";
        Father father1 = read(content, Father.class);
        System.out.println(father1.getName());

        //子类的转换
        Son son = new Son();
        son.setName("mic");
        son.setAge(10);
        System.out.println(write(son)); //{"name":"mic","age":10}
        Son son1 = read("{\"name\":\"mic\",\"age\":10}", Son.class);
        System.out.println(son1.getName() + ":" + son1.getAge()); //mic:10

        // 泛型
        Result<Father> result = new Result<>();
        result.setSuccess(true);
        result.getData().add(father);
        System.out.println(write(result)); //{"success":true,"data":[{"name":"Jack"}]}
        String conent1 = "{\"success\":true,\"data\":[{\"name\":\"Jackson\"}]}";
        Result<Father> result1 = read(conent1, Result.class);
        Result<Father> result2 = read(conent1, new TypeReference<Result<Father>>() {});
        System.out.println(result1);
        System.out.println(result2);
    }
}
