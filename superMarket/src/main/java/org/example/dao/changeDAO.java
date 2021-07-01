package org.example.dao;


import org.example.model.UserInfo;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 修改密码
 * @Date 2021/4/30 下午 15:13
 */
public class changeDAO
{
    //修改密码
    public static int change(UserInfo a, String user, String pass)
    {
        Connection c = null;
        PreparedStatement ps = null;
        try
        {
            c = DBUtil.getConnection();
            String sql = "update tb_operator set password=? where username=?";
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1, pass);  //修改密码
            ps.setString(2, user);  //确定用户
            System.out.println(1);
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
