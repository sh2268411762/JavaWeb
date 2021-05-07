package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    /*
    *   工具类提供JDBC 操作
    *   不足：  1、DS 引用不能改变
    *          2、static代码块出错，NoClassDefoundError -->表示类可以找到，但是类加载失败
    *          3、学了多线程之后，采取双重校验的单例模式来创建DataSource
    *          4、工具类设计上不是最优，数据库框架OMR框架Mybatis，都是模板模式设计的
     */
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

    public static void close(Connection c, Statement s)
    {
        close(c, s, null);
    }

    public static void close(Connection c, Statement s, ResultSet r)
    {
        try
        {
            if (r != null)
            {
                r.close();
            }
            if (s != null)
            {
                s.close();
            }
            if (c != null)
            {
                c.close();
            }
        } catch (SQLException e)
        {
            throw new AppException("DB002", "数据库释放资源出错", e);
        }


    }


}
