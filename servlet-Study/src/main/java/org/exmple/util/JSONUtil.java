package org.exmple.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 工具类
 * @Date 2021/4/28 上午 0:31
 */
public class JSONUtil
{
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //序列化：将 java 对象序列化为JSON 字符串
    //o :java 对象
    //返回值：json 字符串
    public static String serialize(Object o)
    {
        try
        {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
            throw new RuntimeException("json 序列化失败！！！" + o);
        }
    }

    //反序列化：将 输入流或字符串反序列化为 java 对象
    //is :输入流
    //clazz :指定要反序列化的类型
    //<T>
    //返回值：反序列化的对象
    public static <T> T deserialize(InputStream is, Class<T> clazz)
    {
        try
        {
            return MAPPER.readValue(is, clazz);
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException("json 反序列化失败！！！" + clazz.getName());
        }
    }
}
