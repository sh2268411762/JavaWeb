package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/5/2 下午 16:30
 */
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet
{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        String id = req.getParameter("id");
        Article a = ArticleDAO.query(Integer.parseInt(id));
        return a;
    }
}
