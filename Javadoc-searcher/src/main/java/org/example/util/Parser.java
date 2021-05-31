package org.example.util;

import org.example.model.DocInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 一、从本地 api 目录，遍历静态 html 文件
 * 每一个html 需要构建正文索引：本地某个文件
 * 正文索引信息（List<DocInfo>）
 * DocInfo(id, title, content, url)
 * @Date 2021/5/26 下午 14:52
 */
public class Parser
{
    //api 目录
    public static final String API_PATH = "E:\\Doc\\jdk-8u291-docs-all\\api";
    //构建的本地文件正排索引
    public static final String RAW_DATA = "E:\\raw_data.txt";
    //官方api文档的根路径
    public static final String API_BASE_PATH = "https://docs.oracle.com/javase/8/docs/api";

    public static void main(String[] args) throws IOException
    {
        //找到 api 本地路径下的所有HTML文件
        List<File> htmls = listHtml(new File(API_PATH));
        FileWriter fileWriter = new FileWriter(RAW_DATA);

        PrintWriter printWriter = new PrintWriter(fileWriter, true);     //第二个参数，表示自动刷新缓冲区


        for (File html : htmls)
        {
            //一个 html 解析为 DocInfo 有的属性
            DocInfo doc = parseHtml(html);
            //System.out.println(doc);

            //保存本地正排索引文件：输出流输出到目标文件
            //格式：一行为一个 doc ，title + \3 + url + \3 + content
            String uri = html.getAbsolutePath().substring(API_PATH.length());
            System.out.println("parse:" + uri);
            printWriter.println(doc.getTitle() + "\3" + doc.getUrl() + "\3" + doc.getContent());

        }

        //保存本地正排索引文件
    }

    private static DocInfo parseHtml(File html)
    {
        DocInfo doc = new DocInfo();
        doc.setTitle(html.getName().substring(0, html.getName().length() - ".html".length()));
        //获取相对路径
        String uri = html.getAbsolutePath().substring(API_PATH.length());
        doc.setUrl(API_BASE_PATH + uri);
        doc.setContent(parseContent(html));
        return doc;//目前是从本地api目录的html文件解析为文档对象，这步不需要设置id
    }

    /*
     *      解析 html 文件内容
     *      <标签>内容</标签>
     *         只取内容
     */
    private static String parseContent(File html)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            FileReader fileReader = new FileReader(html);
            int i;
            boolean isContent = false;  //是正文拼接
            //一个字符一个字符来读取
            while ((i = fileReader.read()) != -1)
            {
                char ch = (char) i;
                //根据读取的字符 ch 是否是'<','>', isContent决定是否拼接字符、continue
                if (isContent)
                {
                    if (ch == '<')
                    {
                        //当前标签的内容读取结束
                        isContent = false;  //不是正文
                    } else if (ch == '\n' || ch == '\r')
                    {
                        //换行符 \r \n ，有些系统换行符是 \r
                        stringBuilder.append(" ");
                    } else
                    {
                        stringBuilder.append(ch);   //拼接标签内容
                    }
                } else if (ch == '>')
                {
                    //当前不是正文，并且读取到 > ，之后就是正文
                    isContent = true;
                }
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();

    }

    //递归遍历 html 文件
    private static List<File> listHtml(File dir)
    {
        List<File> ret = new ArrayList<>();
        File[] children = dir.listFiles();  //子文件夹和子文件

        if (children != null)
        {
            for (File child : children)
            {
                //递归
                if (child.isDirectory())    //子文件夹：递归调用获取子文件夹内的 html 文件
                {
                    ret.addAll(listHtml(child));
                } else if (child.getName().endsWith(".html"))
                {
                    ret.add(child);
                }
            }
        }
        return ret;
    }

}
