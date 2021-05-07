package org.example.servlet;

import org.example.dao.LoginDAO;
import org.example.exception.AppException;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        User user = LoginDAO.query(username);
        if (user == null)
        {
            throw new AppException("LOG002", "用户不存在");
        }
        if (!user.getPassword().equals(password))
        {
            throw new AppException("LOG003", "用户名或密码错误");
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        //登录成功，创建session
        return null;

//        if ()
//        {
//            //resp.sendRedirect("jsp/articleList.jsp");
//            return null;
//        } else
//        {
//            throw new AppException("LOG001", "用户名或密码错误");
//        }
    }
}
