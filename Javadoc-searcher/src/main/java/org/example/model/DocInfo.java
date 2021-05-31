package org.example.model;

import java.util.Objects;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description DocInfo(id, title, content, url)
 * 每一个本地 html 文件对应一个文档对象
 * @Date 2021/5/26 下午 14:55
 */
public class DocInfo
{
    private Integer id;     //类似数据库主键，识别不同的文档
    private String title;   //标题：html 文件名作为标题
    private String url;     //oracle 官网 api 文档下的 html 的 url
    private String content; //网页正文：<标签>内容</标签>，内容为正文

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocInfo docInfo = (DocInfo) o;
        return Objects.equals(id, docInfo.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "DocInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
