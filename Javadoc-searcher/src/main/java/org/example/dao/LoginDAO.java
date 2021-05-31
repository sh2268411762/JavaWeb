package org.example.dao;

import org.example.model.UserInfo;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/30 上午 0:18
 */
public class LoginDAO
{
    public static UserInfo query(String username)
    {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            c = DBUtil.getConnection();
            String sql = "select id, username, password from user where username=?";
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1, username);
            rs = ps.executeQuery();
            UserInfo user = null;

            while (rs.next())
            {
                user = new UserInfo();
                //设置user的值
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        } finally
        {
            DBUtil.close(c, ps, rs);
        }
    }
}
