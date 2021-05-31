package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.LoginDAO;
import org.example.model.UserInfo;
import org.example.util.UserInfoUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
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
            if (password.equals(user.getPassword()))    //密码也相同
            {
                System.out.println("登录成功");
                mapJson.put("success", true);
                mapJson.put("msg", "登录成功!");
            } else
            {
                //有瑕疵
                mapJson.put("success", false);
                mapJson.put("msg", "用户名或密码错误!");
                System.out.println("用户名或密码错误!");
            }
        } else
        {
            mapJson.put("success", false);
            mapJson.put("msg", "用户名不存在!");
            System.out.println("用户名不存在!");
        }

        PrintWriter pw = resp.getWriter();

        pw.println(new ObjectMapper().writeValueAsString(mapJson));
        pw.flush();
        pw.close();

        //String ret = UserInfoUtil.queryUserInfo(username, password);
        //Map<String, Object> mapJson = new HashMap<>();
//        if ("success".equals(ret))
//        {
//            mapJson.put("success", true);
//            mapJson.put("msg", "登录成功!");
//
//        } else if ("pwd not exist".equals(ret))
//        {
//            mapJson.put("success", false);
//            mapJson.put("msg", "用户名或密码错误!");
//        } else
//        {
//            mapJson.put("success", false);
//            mapJson.put("msg", "用户名不存在!");
//        }

//        PrintWriter pw = resp.getWriter();
//
//        pw.println(new ObjectMapper().writeValueAsString(mapJson));
//        pw.flush();
//        pw.close();

    }
}
