package org.example.dao;


import org.example.model.UserInfo;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 注册用户
 * @Date 2021/4/30 下午 15:13
 */
public class addDAO
{
    //注册新增
    public static int insert(UserInfo a, String user, String pass)
    {
        Connection c = null;
        PreparedStatement ps = null;
        try
        {
            c = DBUtil.getConnection();
            String sql = "insert into tb_operator(username,password,name,power) values(?,?,?,?)";
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, "shark");
            ps.setString(4, "操作员");

            System.out.println("1");
            return ps.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        } finally
        {
            DBUtil.close(c, ps);
        }
    }


}
