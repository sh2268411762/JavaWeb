package org.exmple.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 上午 11:38
 */
public class JSONUtilTest
{
    //单元测试：junit 框架使用方法上@Test 注解，保证方法为public void
    @Test
    public void testSerialize()
    {
        //测试序列化操作，使用map 模拟
        Map map = new HashMap();
        map.put("name", "java40班");
        map.put("students", new int[]{1, 2});
        String json = JSONUtil.serialize(map);
        System.out.println(json);
        Assert.assertNotNull(json);
    }

    @Test
    public void testDerserialize()
    {
        //测试反序列化

        //类加载器加载某个资源时，返回输入流
        InputStream is = JSONUtilTest.class.getClassLoader()
                .getResourceAsStream("login.json");

        Map map = JSONUtil.deserialize(is, HashMap.class);
        System.out.println(map);
        Assert.assertNotNull(map);
    }

}
