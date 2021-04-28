package org.exmple.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/21 下午 13:15
 */
//注解使用：小括号包裹多个属性，属性名=属性值，多个之间逗号间隔，属性名为value可缺省
//Servlet定义服务：路径必须是 / 开始，否则Tomcat启动报错
@WebServlet("/loginJSON")
public class LoginJSONServlet extends HttpServlet
{

    //每次http 请求映射到某个Servlet 的资源路径，都会调用service 生命周期方法
    //如果请求方法没有重写，就会调用父类的对应请求方法，返回405
    //如果重写，会将数据包装为一个Request请求对象，这时候虽然还没有相应，
    //但是也包装了一个Response 对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //设置清切，相应编码及相应数据类型（为相应设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //解析请求数据
        //getParmeter ：获取请求数据：url和请求体，数据格式为k1=v1 & k2=v2
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.printf("==================================user:(%s) pass:(%s)\n", u, p);


        //数据库密码验证
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("success");  //连接成功
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","sunhao2268411762");
            System.out.println("1");

            String sql = "select * from 用户表（登录）";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            //返回响应数据
            PrintWriter pw = resp.getWriter();  //获取IO输出流
            boolean flag = false;
            while (rs.next())
            {
                String name = rs.getString("user");
                String pass = rs.getString("password");
                if (name.equals(u) && pass.equals(p))
                {
                    pw.println("{\"success\":true}");
                    flag = true;
                    break;
                }
            }
            if (!flag)  //说明不是break出来的
            {
                pw.println("{\"success\":false}");
            }
            pw.flush(); //有缓冲的io操作，需要刷新缓冲区，才会真正的发送数据
            pw.close(); //关闭流
            //进入数据库
        } catch (Exception e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
