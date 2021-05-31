package org.example.util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.model.DocInfo;
import org.example.model.Weight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 构建索引：
 * 正排索引：从本地文件数据中心读取到 java 内存（类似于数据库保存的数据）
 * 倒排索引：构建 Map<String , List<信息>> （类似于数据库 hash 索引）
 * Map键：关键词（分词来完成）
 * Map值：信息
 * 信息：DocInfo 对象引用 或 DocInfo 的id
 * 权重：（标题对应关键词数量 * 数字 + 正文对应关键词数量 * 数字）
 * 关键词：（是否需要，待定）
 * @Date 2021/5/26 下午 16:34
 */
public class Index
{
    //正排索引
    private static final List<DocInfo> FORWARD_INDEX = new ArrayList<>();
    //倒排索引
    private static final Map<String, List<Weight>> INVERTED_INDEX = new HashMap<>();


    /*
     * 构建正排索引的内容：从本地 raw_data.txt 中读取并保存
     */
    public static void buildForwardIndex()
    {
        try
        {
            FileReader fileReader = new FileReader(Parser.RAW_DATA);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int id = 0;  //行号设置为 id
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                if ("".equals(line.trim()))
                {
                    continue;
                }
                //一行对应一个 DocInfo 对象，类似数据库一行对应形影的java对象
                DocInfo doc = new DocInfo();
                doc.setId(++id);
                //按照分隔符 \3 切割
                String[] parts = line.split("\3");
                doc.setTitle(parts[0]);
                doc.setUrl(parts[1]);
                doc.setContent(parts[2]);

                //添加到整排索引
                FORWARD_INDEX.add(doc);

            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建倒排索引：从java内存中正排索引获取文档信息来构建
     */
    public static void buildInvertedIndex()
    {
        for (DocInfo doc : FORWARD_INDEX)
        {
            Map<String, Weight> cache = new HashMap<>();
            List<Term> titleFencis = ToAnalysis.parse(doc.getTitle()).getTerms();
            for (Term titleFenci : titleFencis)
            {
                Weight w = cache.get(titleFenci.getName());
                //获取标题分词键对应的weight
                if (w == null)
                {
                    //如果没有，就创建一个并放到map中
                    w = new Weight();
                    w.setDoc(doc);
                    w.setKeyword(titleFenci.getName());     //设置关键词
                    cache.put(titleFenci.getName(), w);     //放进 Map 里边
                }
                //标题分词，权重+10
                w.setWeight(w.getWeight() + 10);
            }

            //正文的分词处理：逻辑和标题分词逻辑一样
            List<Term> contentFencis = ToAnalysis.parse(doc.getContent()).getTerms();
            for (Term contentFenci : contentFencis)
            {
                Weight w = cache.get(contentFenci.getName());
                if (w == null)
                {
                    w = new Weight();
                    w.setDoc(doc);
                    w.setKeyword(contentFenci.getName());
                    cache.put(contentFenci.getName(), w);
                }
                //正文分词，权重+1
                w.setWeight(w.getWeight() + 1);
            }

            //把临时保存的map数据（keyword-weight）全部保存到倒排索引
            for (Map.Entry<String, Weight> e : cache.entrySet())
            {
                String keyword = e.getKey();
                Weight w = e.getValue();
                //更新保存到倒排索引 Map<String, List<Weight>> --> 多个文档
                //同一个关键词，保存在一个List
                //先在倒排索引中，通过keyword获取已有的值
                List<Weight> weights = INVERTED_INDEX.get(keyword);
                if (weights == null)
                {
                    //如果拿不到，就创建一个，并存放进倒排索引
                    weights = new ArrayList<>();
                    INVERTED_INDEX.put(keyword, weights);
                }

                //System.out.println(keyword + "：（ " + w.getDoc().getId() + "，" + w.getWeight() + "）");
                //存在则直接放进倒排索引
                weights.add(w);     //倒排中，添加当前文档每个分词对应的weight对象
            }
        }
    }

    //通过关键词（分词）在倒排中查找映射的文档（多个文档，倒排拉链）
    public static List<Weight> get(String keyword)
    {
        return INVERTED_INDEX.get(keyword);
    }

    public static void main(String[] args)
    {
        //测试正排索引
        Index.buildForwardIndex();
        //FORWARD_INDEX.forEach(System.out::println);

        Index.buildInvertedIndex();
        //测试倒排内容是否正确
        for (Map.Entry<String, List<Weight>> e : INVERTED_INDEX.entrySet())
        {
            String keyword = e.getKey();
            System.out.print(keyword + ": ");
            List<Weight> weights = e.getValue();//不校验weight中的doc对象，正排索引已经测试过
            weights.stream()
                    .map(w ->
                    {//map操作：把list中每一个对应转换为其他对象
                        return "（" + w.getDoc().getId() + ", " + w.getWeight() + "）";
                    })//转换完，会变为List<String>
//                    .collect(Collectors.toList());//返回List<String>
                    .forEach(System.out::print);
            System.out.println();
        }
    }
}
