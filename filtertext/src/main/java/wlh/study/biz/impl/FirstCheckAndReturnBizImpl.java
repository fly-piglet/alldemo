package wlh.study.biz.impl;

import wlh.study.biz.CheckAndReturnBiz;
import wlh.study.dto.News;
import wlh.study.dto.Paragraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirstCheckAndReturnBizImpl implements CheckAndReturnBiz {
    @Override
    public News firstCheckAndReturn(News news) {

        ArrayList<Paragraph> paragraphList = news.getParagraphList();

        Boolean allmatchFlag = false;
        for (Paragraph paragraph : paragraphList) {
            String line = paragraph.getParagraph();
            Set<String> matchResult = new HashSet<>();
            Boolean matchFlag = false;
            String[] matchString = new String[]{"税","税负"};
            for (int i = 0; i < matchString.length; i++) {
                if (line.contains(matchString[i])) {
                    allmatchFlag = true;
                    matchResult.add(matchString[i]);
                }
            }
            paragraph.setMatchResult(matchResult);
        }
        // 匹配到返回当前news
        if (allmatchFlag) {
            News returnNews = new News(news.getNewsId(), news.getContext(), news.getParagraphList());
            return returnNews;
        }
        // 没有匹配到直接返回空对象
        return null;
    }
}
