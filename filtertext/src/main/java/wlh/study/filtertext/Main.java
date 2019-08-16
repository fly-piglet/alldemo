package wlh.study.filtertext;

import wlh.study.biz.CheckAndReturnBiz;
import wlh.study.biz.impl.FirstCheckAndReturnBizImpl;
import wlh.study.biz.impl.SecondCheckAndReturnBizImpl;
import wlh.study.biz.impl.ThirdCheckAndReturnBizImpl;
import wlh.study.dto.News;
import wlh.study.dto.Paragraph;

import java.io.*;
import java.util.*;

/**
 * 主要逻辑
 */
public class Main {

    public static void main(String[] args) {
        // 获取来源文件夹
        String sourcePath = "/Users/wulonghuai/github/filtertext/javademo/src/main/resources/source";
        // 遍历获得所有文件
        File sourcePathFile = new File(sourcePath);
        File[] files = sourcePathFile.listFiles();
        // 输入参数校验：校验路径，校验路径下面的文件
        if (validateInput(sourcePathFile, files)) return;
        // 获取输入数据
        LinkedHashMap<String, LinkedHashMap<String, News>> inputMap = getTextFileNameToNewsListMap(files);
        // 第一次过滤的文章(含有文章，全部段落)
        LinkedHashMap<String, LinkedHashMap<String, News>> fistFilterMap = new LinkedHashMap<>();
        // 第二次过滤的文章（含有文章，匹配段落）
        LinkedHashMap<String, LinkedHashMap<String, News>> secondFilterMap = new LinkedHashMap<>();
        // 第三次过滤的文章（含有文章，在第一次的基础上，进行过滤）
        LinkedHashMap<String, LinkedHashMap<String, News>> thirdFilterMap = new LinkedHashMap<>();

        // 第一步筛选出所有含税或税负字眼的文章及对应的新闻ID(保留全部段落)
        inputMap.forEach((fileName, newsMap)->{
            newsMap.forEach((newsId, news) -> {
                filter(fistFilterMap, fileName, news, new FirstCheckAndReturnBizImpl());
            });
        });
        // 第二部筛选出所有含税或税负字眼的文章及对应的新闻ID(保留匹配段落)
        fistFilterMap.forEach((fileName, newsMap)->{
            newsMap.forEach((newsId, news) -> {
                filter(secondFilterMap, fileName, news, new SecondCheckAndReturnBizImpl());
            });
        });

        // 第二部筛选出所有其他字眼的文章及对应的新闻ID(保留匹配段落)
        fistFilterMap.forEach((fileName, newsMap)->{
            newsMap.forEach((newsId, news) -> {
                filter(thirdFilterMap, fileName, news, new ThirdCheckAndReturnBizImpl());
            });
        });

        // 第一部分数据输出
        System.out.println(secondFilterMap);
        // 第二部分数据输出
        System.out.println(thirdFilterMap);

        // 第二部分输出的时候，注意含有董事长的要保存文章，其他只保留段落

        // 对处理完毕的数据结构，获取持久化存储策略，进行持久化处理，存储为文件或者文件夹

        // 文本筛选需求：争取将筛选结果输出为excel表格
    }

    private static void filter(LinkedHashMap<String, LinkedHashMap<String, News>> fistFilterMap, String fileName, News news, CheckAndReturnBiz biz) {
        News returnNews = biz.firstCheckAndReturn(news);
        if (returnNews != null) {
            LinkedHashMap<String, News> fileNameNewsMap = fistFilterMap.get(fileName);
            // 初始化
            if (fileNameNewsMap == null) {
                fileNameNewsMap = new LinkedHashMap<>();
            }
            fileNameNewsMap.put(returnNews.getNewsId(), returnNews);
            fistFilterMap.put(fileName, fileNameNewsMap);
        }
    }

    private static boolean validateInput(File sourcePathFile, File[] files) {
        if (!sourcePathFile.isDirectory()) {
            System.out.println("来源路径，请输入目录，保证目录中只有文本文件");
            return true;
        }
        if (files == null && files.length == 0) {
            System.out.println("来源路径没有相关文件，请放置过滤的文本文件");
            return true;
        }
        return false;
    }

    private static LinkedHashMap<String, LinkedHashMap<String, News>> getTextFileNameToNewsListMap(File[] files) {
        // 定义返回值
        LinkedHashMap<String, LinkedHashMap<String, News>> textFileNameToNewsListMap = new LinkedHashMap<String, LinkedHashMap<String, News>>(files.length);

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            try {
                textFileNameToNewsListMap.put(file.getName(), getNewsList(file));
            } catch (IOException e) {
                System.out.println("文本文件" + file.getName() + ": 处理出现失败");
            }
        }
        
        // 返回获取的数据
        return textFileNameToNewsListMap;
    }

    private static LinkedHashMap<String, News> getNewsList(File file) throws IOException {
        // 将文件获取成为流
        LinkedHashMap<String, News> newIdToNewsMap = new LinkedHashMap<String, News>();

        // 设定转码，获取文件流
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB2312"));

        StringBuilder lineStrBuf = new StringBuilder();// 拼接读取的内容(while循环中不到断尾时,将字符一个个加入拼接)
        String tempLine;// 临时变量，存储sb去除空格的内容
        String tempNewsId = ""; // 临时新闻id: 第一栏外的新闻不进行收录

        int ch;
        // 按照字符进行循环
        while ((ch = reader.read()) != -1) {
            // 按照行来拆分, 遇到换行符就进入
            if ((char) ch == '\r' || (char) ch == '\n') {

                // 获取当前行的字符数据，去除前后空格
                tempLine = lineStrBuf.toString().trim();
                // 不是空行才进行处理
                if (!"".equals(tempLine)) {
                    String newsId = getNewsId(tempLine);
                    if (!"".equals(newsId)) {
                        // 创建新闻存储
                        createNews(newIdToNewsMap, newsId);

                        // 将含有新闻标题的那一行，去除新闻编号
                        String quchuLine = tempLine.replace(newsId + ",", "");
                        setContext(newIdToNewsMap, quchuLine, newsId);
                        // 处理段落数据

                        newIdToNewsMap.get(newsId).getParagraphList().add(new Paragraph(quchuLine));


                        // 存储临时id
                        tempNewsId = newsId;
                    } else {
                        // 临时编号不等于空的时候，处理文章数据
                        if (!"".equals(tempNewsId)) {
                            setContext(newIdToNewsMap, tempLine, tempNewsId);
                            // 处理段落数据
                            newIdToNewsMap.get(tempNewsId).getParagraphList().add(new Paragraph(tempLine));
                        }
                    }

                }
                lineStrBuf.delete(0, lineStrBuf.length());//清空sb
            } else {
                lineStrBuf.append((char) ch);
            }
        }
        // 将流转换为新闻实体的流
        return newIdToNewsMap;
    }

    private static void setContext(LinkedHashMap<String, News> newIdToNewsMap, String tempLine, String tempNewsId) {
        String context = newIdToNewsMap.get(tempNewsId).getContext();
        char charStr = '\n';
        newIdToNewsMap.get(tempNewsId).setContext(context + tempLine + charStr);
    }

    /**
     * 创建新闻实体，放到map中
     * @param newIdToNewsMap
     * @param newsId
     */
    private static void createNews(LinkedHashMap<String, News> newIdToNewsMap, String newsId) {
        News news = new News();
        news.setNewsId(newsId);
        news.setContext("");
        news.setParagraphList(new ArrayList<>());
        newIdToNewsMap.put(newsId, news);
    }

    /**
     * 获取新闻Id
     * @param tempLine
     * @return
     */
    private static String getNewsId(String tempLine) {
        String newsId = "";
        // 获取新闻id的规则：1. 段落长度要大于9，段落第9个字符是逗号，段落中包含字符"63"
        if (tempLine.length()> 9 && tempLine.substring(8,9).equals(",") && tempLine.substring(0,8).contains("63")) {
            newsId = tempLine.substring(0,8);
        }
        return newsId;
    }

}
