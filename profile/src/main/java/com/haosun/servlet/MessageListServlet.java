package com.haosun.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haosun.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/5/12 下午 15:42
 */
@WebServlet("/message-list.json")
public class MessageListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Message> messageList = getMessageList();


        String jsonMessage = buildJSONByJackson(messageList);
        System.out.println(jsonMessage);
    }

    private String buildJSONByJackson(List<Message> messageList)
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            System.out.println("来");
            String ret = mapper.writeValueAsString(messageList);
            System.out.println("不来");
            return ret;
        } catch (JsonProcessingException e)
        {
            System.out.println("错误");
            e.printStackTrace();
            return "";
        }
    }


    private String buildJSON(List<Message> messageList)
    {
        StringBuilder sb = new StringBuilder("[");

        for (Message message : messageList)
        {
            sb.append("{");
            sb.append("\n    \"id:\"");
            sb.append(message.id);
            sb.append(",\n");
            sb.append("    \"who:\"");
            sb.append("\"");
            sb.append(message.who);
            sb.append("\"");
            sb.append(",\n");
            sb.append("    \"when:\"");
            sb.append("\"");
            sb.append(message.when);
            sb.append("\"");
            sb.append(",\n");
            sb.append("    \"what:\"");
            sb.append("\"");
            sb.append(message.what);
            sb.append("\"");
            sb.append("\n},\n");
        }

        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    public List<Message> getMessageList()
    {
        List<Message> messageList = new ArrayList<>();
        Message m1 = new Message();
        m1.id = 1;
        m1.who = "达摩";
        m1.when = "time1";
        m1.what = "一闪接大平A接二段大";
        messageList.add(m1);

        Message m2 = new Message();
        m2.id = 2;
        m2.who = "达摩";
        m2.when = "time2";
        m2.what = "一闪接大平A接二";
        messageList.add(m2);


        Message m3 = new Message();
        m3.id = 3;
        m3.who = "达摩";
        m3.when = "time3";
        m3.what = "一闪接大平A";
        messageList.add(m3);


        Message m4 = new Message();
        m4.id = 4;
        m4.who = "达摩";
        m4.when = "time4";
        m4.what = "一闪接大接二段大";
        messageList.add(m4);

        return messageList;
    }
}
