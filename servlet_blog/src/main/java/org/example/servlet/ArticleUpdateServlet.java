package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/5/2 下午 16:44
 */
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet
{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        InputStream is = req.getInputStream();
        Article a = JSONUtil.deserialize(is,Article.class);
        int num = ArticleDAO.update(a);
        return null;
    }
}
