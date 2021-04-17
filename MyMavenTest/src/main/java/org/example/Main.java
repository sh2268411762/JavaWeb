package org.example;

import java.sql.*;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description Maven 初识
 * @Date 2021/4/14 下午 19:16
 */

//写的Java代码，一般的包放在groupID.artifactID下
public class Main
{
    public static void main(String[] args)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "sunhao2268411762");
            System.out.println(conn);
        } catch (Exception e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }
}
