package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.AppException;
import org.example.model.Article;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/30 下午 15:13
 */
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet
{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        //获取session，如果没有就返回null
        HttpSession session = req.getSession(false);
//        if (session == null)
//        {
//            throw new AppException("ART002","用户眉头登陆，不允许访问");
//        }
        //获取登录时创建的session保存的用户信息
        User user = (User) session.getAttribute("user");
//        if(user == null)
//        {
//            throw new AppException("ART003","会话异常，请重新登陆");
//        }
        //用户已登录，并且保存了相关信息

        return ArticleDAO.queryByUserId(user.getId());
    }
}
