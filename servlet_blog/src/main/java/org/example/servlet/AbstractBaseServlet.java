package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.prefs.AbstractPreferences;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 下午 14:52
 */
public abstract class AbstractBaseServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //设置请求，相应编码及相应数据类型（为相应设置Content-Type数据类型）

        //设置请求体的编码类型
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        //设置响应体的编码类型
        resp.setCharacterEncoding("UTF-8");
        //设置响应体的数据类型（浏览器要采取什么方式执行
        resp.setContentType("application/json");

        //Session 会话管理：除登录和注册接口，其他都需要登录后访问
        //req.getServletPath()

        JSONResponse json = new JSONResponse();
        try
        {
            //调用子类重写的方法
            Object data = process(req, resp);
            //操作成功
            json.setSuccess(true);
            json.setData("data");
        } catch (Exception e)
        {
            //异常处理
            //JDBC：SQLException
            //JSON：自定义异常返回错误信息
            e.printStackTrace();

            //json.setSuccess 不用设置,因为new的时候就是false
            String code = "UNKNOWN";
            String s = "未知错误";
            if (e instanceof AppException)
            {
                code = ((AppException) e).getCode();
                System.out.println(code);
                s = e.getMessage();
            }
            json.setCode(code);
            json.setMessage(s);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req, resp);
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
