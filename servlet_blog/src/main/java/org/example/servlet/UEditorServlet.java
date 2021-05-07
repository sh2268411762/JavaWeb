package org.example.servlet;

import org.example.util.MyActionEnter;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/5/6 下午 21:26
 */

/**
 * ueditor 富文本编辑器
 * 1、修改idea 中Tomcat配置的应用上下文路径，maven中的 finalName
 * 2、修改webapp/static/ueditor/ueditor.config.js(应用上下文路径 + 服务路径)
 * 3、实现后端接口（和第二步的服务路径保持一致）
 * 4、修改config.json配置：上传图片到服务器本地的路径，即访问的主机ip，port，应用上下文路径
 * 、idea 运行时，需要配置 tomcat：将tomcat/webapps 路径下的项目都部署
 */
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //加载类的根路径
        URL url = UEditorServlet.class.getClassLoader().
                getResource("config.json");
        //URL 获取到时，都是编码后的字符串，需要解码后在使用
        String path = URLDecoder.decode(url.getPath(), "UTF-8");
        //框架提供的富文本编辑器上传功能
        MyActionEnter enter = new MyActionEnter(req, path);
        String exec = enter.exec();   //执行
        PrintWriter pw = resp.getWriter();
        pw.println(exec);
        pw.flush();
        pw.close();
    }
}
