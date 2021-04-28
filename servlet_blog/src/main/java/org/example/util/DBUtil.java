package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 下午 15:09
 */
public class DBUtil
{
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?" +
            "user=root&password=sunhao2268411762&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final DataSource DS = new MysqlDataSource();

    static
    {
        ((MysqlDataSource) DS).setUrl(URL);
    }

    public static Connection getConnection()
    {
        try
        {
            return DS.getConnection();
        } catch (SQLException throwables)
        {
            //抛出自定义异常
            throw new AppException("DB001", "获取数据库连接失败");
        }
    }
}
