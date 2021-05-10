package com.haosun.profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/5/9 下午 18:02
 */
@WebServlet("")
public class HomeServlet extends HttpServlet
{
    //TODO:需要修复线程安全问题
    private static int count;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        count++;

        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");

        resp.setContentType("text/html; charset=utf-8");

        PrintWriter pw = resp.getWriter();
        String template = "<!DOCTYPE html>\n" +
                "<html lang=\"\">\n" +
                "    <!-- 注释 -->\n" +
                "    <em>\n" +
                "        斜体元素\n" +
                "    </em>\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>个人名片</title>\n" +
                "\n" +
                "        <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "\n" +
                "    </head>\n" +
                "\n" +
                "    <body>\n" +
                "        <div>访问次数：:count:</div>\n" +
                "        <div>\n" +
                "            <h1>:name:</h1>\n" +
                "            <p><strong>大</strong>学生</p>\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "        <em>1</em><em>2</em><em>3</em>\n" +
                "        <p>4</p><p>5</p><p>6</p>\n" +
                "\n" +
                "        <div class=\"hobby\">\n" +
                "            <!-- ol：有序列表  ul：无序列表 -->\n" +
                "            <h2>这货的爱好</h2>\n" +
                "            <ul>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115347612\">写代码</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/109665028\">打游戏</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/106148431\">打篮球</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115961511\">看电影</a></li>\n" +
                "                <li>看电影</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "\n" +
                "        <div>\n" +
                "            <h2>学习经历</h2>\n" +
                "            <ol>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115917383\">小学</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115919317\">初中</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115896139\">高中</a></li>\n" +
                "                <li><a href=\"https://blog.csdn.net/weixin_43520256/article/details/115874951\">大学</a></li>\n" +
                "                <li><a href='https://blog.csdn.net/weixin_43520256/article/details/115874951'>大学</a></li>\n" +
                "            </ol>\n" +
                "        </div>\n" +
                "        <p>7</p><p>8</p><p>9</p><p>10</p><p>11</p><p>12</p><p>13</p><p>14</p><p>15</p>\n" +
                "\n" +
                "        <img src=\"image/01.jpg\"/>\n" +
                "\n" +
                "        <div id=\"first\">\n" +
                "            AI\n" +
                "        </div>\n" +
                "\n" +
                "        <div id=\"second\" >\n" +
                "            Iverson\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>";
        if (name == null)
        {
            name = "枳洛淮南";
        }
        String content = template.replace(":name:", name).replace(":count:", String.valueOf(count));
        pw.println(content);

    }
}
