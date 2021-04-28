package org.example.servlet;

import org.example.exception.AppException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 下午 15:07
 */
@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet
{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("abc".equals(username))
        {
            //resp.sendRedirect("jsp/articleList.jsp");
            return null;
        } else
        {
            throw new AppException("LOG001", "用户名或密码错误");
        }
    }
}
