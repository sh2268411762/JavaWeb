package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.model.Result;
import org.example.model.Weight;
import org.example.util.Index;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//根据前端请求路径，定义后端服务路径
// loadOnStartup 属性表示是否在启动时初始化，默认-1启动不初始化，第一次请求初始化
@WebServlet(value = "/search", loadOnStartup = 0)
public class SearchServlet extends HttpServlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        //初始化操作
        //先构建正排索引，再根据正排构建倒排
        Index.buildForwardIndex();      //构建正排
        Index.buildInvertedIndex();     //构建倒排
        System.out.println("init complete <--> 初始化完成!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");      //设置编码
        resp.setCharacterEncoding("UTF-8");     //
        resp.setContentType("application/json");    // ajax请求，响应json格式

        //构造返回给前端的内容：使用对象，之后再序列化为json字符串
        Map<String, Object> map = new HashMap<>();
        //解析请求数据
        String query = req.getParameter("query");   //获取搜索框内容
        List<Result> results = new ArrayList<>();
        try
        {
            //根据搜索内容处理搜索业务
            //校验请求数据：搜索内容
            if (query == null || query.trim().length() == 0)
            {
                //搜索框内无内容    去首尾空格后为空字符串
                map.put("ok", false);   //操作失败
                map.put("msg", "搜索内容为空");
            } else  //搜索框内有内容
            {
                //1.根据搜索内容，进行分词，遍历每个分词
                for (Term t : ToAnalysis.parse(query).getTerms())
                {
                    String fenci = t.getName();     //搜索的分词

                    //2.每个分词，在倒排中查找对应的文档（一个分词对应多个文档）
                    List<Weight> weights = Index.get(fenci);

                    //3.一个文档转换为一个Result（不同分词可能存在相同文档，需要合并）
                    for (Weight w : weights)
                    {
                        //转换 weight 为 result
                        Result r = new Result();
                        r.setId(w.getDoc().getId());
                        r.setTitle(w.getDoc().getTitle());
                        r.setWeight(w.getWeight());
                        r.setUrl(w.getDoc().getUrl());
                        //文档内容超过60的部分隐藏为...
                        String content = w.getDoc().getContent();
                        r.setDesc(content.length() <= 100 ? content : content.substring(0, 100) + "...");
                        results.add(r);
                    }
                }
                //4.对List<Result>排序：权重降序排序
                results.sort(new Comparator<Result>()
                {
                    @Override
                    public int compare(Result o1, Result o2)
                    {
                        //return Integer.compare(o1.getWeight(), o2.getWeight());//权重升序
                        return Integer.compare(o2.getWeight(), o1.getWeight());//权重降序
                    }
                });
                //2、
                //results.sort((o1, o2) -> {//lambda写法
                //return Integer.compare(o2.getWeight(), o1.getWeight());//权重降序
                //});

                //3、
//                //lambda简写：直接给一个返回值
//                results.sort((o1, o2) -> Integer.compare(o2.getWeight(), o1.getWeight()));//权重降序


                map.put("ok", true);    //处理成功
                map.put("data", results);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            map.put("ok", false);   //操作失败
            map.put("msg", "未知错误");
        }
        PrintWriter pw = resp.getWriter();      //获取输出流
        //设置响应体内容：map对象序列化为json字符串
        pw.println(new ObjectMapper().writeValueAsString(map));
    }
}
