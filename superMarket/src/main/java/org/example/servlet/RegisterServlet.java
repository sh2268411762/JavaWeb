package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.LoginDAO;
import org.example.dao.addDAO;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("Application/json");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " " + password);

        Map<String, Object> mapJson = new HashMap<>();
        UserInfo user = LoginDAO.query(username);
        //用户名相同
        if (user != null && username.equals(user.getUsername()))
        {
            //有瑕疵
            mapJson.put("success", false);
            mapJson.put("msg", "用户名已存在!");
            System.out.println("用户名已存在!");
        } else
        {
            //可注册，user 为空或与数据库中用户的用户名不相同
            mapJson.put("success", true);
            addDAO.insert(user, username, password);
            mapJson.put("msg", "注册成功，登录!");
            System.out.println("注册成功!");
        }

        PrintWriter pw = resp.getWriter();

        pw.println(new ObjectMapper().writeValueAsString(mapJson));
        pw.flush();
        pw.close();
    }
}
