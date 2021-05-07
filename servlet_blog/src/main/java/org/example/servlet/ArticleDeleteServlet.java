package org.example.servlet;

import org.example.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/30 下午 17:47
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet
{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        String ids = req.getParameter("ids");
        int num = ArticleDAO.delete(ids.split(","));
        return null;
    }
}
