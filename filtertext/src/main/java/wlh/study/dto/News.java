package wlh.study.dto;

import javax.print.attribute.standard.PageRanges;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class News {

    // 新闻id
    private String newsId;
    // 不含有新闻id的文本内容数据
    private String context;
    // 段落明细
    private ArrayList<Paragraph> paragraphList;

    /**
     * 获取所有文章匹配的字段
     * @return
     */
    private Set<String> getNewMatch() {
        Set<String> set = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            set.addAll(paragraph.getMatchResult());
        }
        return set;
    }

    public News() {
    }

    public News(String newsId, String context, ArrayList<Paragraph> paragraphList) {
        this.newsId = newsId;
        this.context = context;
        this.paragraphList = paragraphList;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public ArrayList<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(ArrayList<Paragraph> paragraphList) {
        this.paragraphList = paragraphList;
    }
}
