package org.exmple.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet("/login301")
public class Login301Servlet extends HttpServlet
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
        resp.setContentType("text/html");

        //解析请求数据
        //getParmeter ：获取请求数据：url和请求体，数据格式为k1=v1 & k2=v2
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.printf("==================================user:(%s) pass:(%s)\n", u, p);
        if ("abc".equals(u) && "123".equals(p))
        {
            //重定向
            //返回3XX状态码 + Location 相应头，表示要跳转的路径米浏览器接收到相应数据后自动跳转
            resp.sendRedirect("home.html");  //重定向：http状态码设置为 301/302/307 响应头Location
        } else if ("abc".equals(u))
        {
            //转发
            //一次请求，后端接收直接吧转发路径的资源作为响应体返回
            //区别
            //1、URL路径是否改变：重定向会改变，转发不变
            //2、重定向发起两次网络请求，转发一次
            req.getRequestDispatcher("home.html").forward(req, resp);
        } else
        {
            //返回响应数据
            PrintWriter pw = resp.getWriter();  //获取IO输出流
            pw.println("登录失败！！！");
            pw.println("<h3>不欢迎你：" + u + "或密码错误：" + p + "</h3>");
            pw.flush(); //有缓冲的io操作，需要刷新缓冲区，才会真正的发送数据
            pw.close(); //关闭流
        }
    }
}
