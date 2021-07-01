package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.LoginDAO;
import org.example.dao.changeDAO;
import org.example.model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/modpass")
public class ChangeServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("Application/json");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");


        Map<String, Object> mapJson = new HashMap<>();
        UserInfo user = LoginDAO.query(username);
        if (user == null)
        {
            //有瑕疵
            mapJson.put("success", false);
            mapJson.put("msg", "没有该用户!");
            System.out.println("没有该用户");
        } else if (password.equals(newPassword))
        {
            //有瑕疵
            mapJson.put("success", false);
            mapJson.put("msg", "与原密码相同!");
            System.out.println("与原密码相同!");
        } else
        {
            mapJson.put("success", true);
            changeDAO.change(user, username, newPassword);
            mapJson.put("msg", "修改密码成功，登录!");
            System.out.println("修改密码!");
        }

        PrintWriter pw = resp.getWriter();

        pw.println(new ObjectMapper().writeValueAsString(mapJson));
        pw.flush();
        pw.close();

    }
}
