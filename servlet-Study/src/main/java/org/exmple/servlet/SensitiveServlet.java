package org.exmple.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/21 下午 13:15
 */
//注解使用：小括号包裹多个属性，属性名=属性值，多个之间逗号间隔，属性名为value可缺省
//Servlet定义服务：路径必须是 / 开始，否则Tomcat启动报错
@WebServlet("/sen")
public class SensitiveServlet extends HttpServlet
{

    //每次http 请求映射到某个Servlet 的资源路径，都会调用service 生命周期方法
    //如果请求方法没有重写，就会调用父类的对应请求方法，返回405
    //如果重写，会将数据包装为一个Request请求对象，这时候虽然还没有相应，
    //但是也包装了一个Response 对象
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter pw = resp.getWriter();  //获取IO输出流

        //设置请求，相应编码及相应数据类型（为相应设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        HttpSession session = req.getSession(false);
        if (session == null)
        {
            System.out.println("session 为空");
            resp.setStatus(401);
            pw.println("敏感资源，需要登录后访问");
        } else
        {
            String username = (String) session.getAttribute("username");
            System.out.println("session存在，用户名为：" + username);
        }

        //返回响应数据
        pw.flush(); //有缓冲的io操作，需要刷新缓冲区，才会真正的发送数据
        pw.close(); //关闭流
    }
}
