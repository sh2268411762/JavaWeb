package org.example.util;

import org.example.dao.LoginDAO;
import org.example.model.UserInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoUtil
{
    private static final String USERINFO_PATH = "D:\\搜索引擎\\userInfo.txt";
    private static final File file = new File(USERINFO_PATH);

    //在文件中插入注册用户信息
    public static String AddUserInfo(UserInfo user)
    {

        List<String> list = new ArrayList<>();

        Map<String, Boolean> map = new HashMap<>();
        FileWriter fw = null;
        PrintWriter pw = null;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ret;
            while ((ret = br.readLine()) != null)
            {
                String[] rets = ret.split("\3");
                list.add(rets[0]);
            }
            if (list.contains(user.getUsername()))
            {
                System.out.println("用户名已存在");
                return "userInfo already exist";
            }
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw, true);
            pw.println(user.getUsername() + "\3" + user.getPassword());
            System.out.println("注册成功");
            return "success";

        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        } finally
        {
            try
            {
                if (pw != null)
                {
                    pw.close();
                }
                if (fw != null)
                {
                    fw.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //检验登录
    public static String queryUserInfo(String username, String password)
    {
        //user 的用户名，密码已经设置
        UserInfo user = LoginDAO.query(username);
        if (username.equals(user.getUsername()))    //用户名相同
        {
            if (password.equals(user.getPassword()))    //密码也相同
            {
                System.out.println("登录成功");

                return "success";
            } else
            {
                //有瑕疵
                return "password not exist";
            }
        }

        return "userInfo not exist";
    }
}
