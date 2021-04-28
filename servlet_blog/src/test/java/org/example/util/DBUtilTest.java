package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 下午 17:59
 */
public class DBUtilTest
{
    @Test
    public void test()
    {
        Connection conn = DBUtil.getConnection();
        Assert.assertNotNull(conn);
    }
}
