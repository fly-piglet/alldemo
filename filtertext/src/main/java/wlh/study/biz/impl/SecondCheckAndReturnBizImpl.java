package wlh.study.biz.impl;

import wlh.study.biz.CheckAndReturnBiz;
import wlh.study.dto.News;
import wlh.study.dto.Paragraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondCheckAndReturnBizImpl implements CheckAndReturnBiz {
    @Override
    public News firstCheckAndReturn(News news) {
        ArrayList<Paragraph> paragraphList = news.getParagraphList();
        ArrayList<Paragraph> newParagraphList = new ArrayList<>();

        Boolean allmatchFlag = false;
        for (Paragraph paragraph : paragraphList) {
            String line = paragraph.getParagraph();
            Set<String> matchResult = new HashSet<>();
            Boolean matchFlag = false;
            String[] matchString = new String[]{"税","税负"};
            for (int i = 0; i < matchString.length; i++) {
                if (line.contains(matchString[i])) {
                    allmatchFlag = true;
                    matchFlag = true;
                    matchResult.add(matchString[i]);
                }
            }
            if (matchFlag) {
                newParagraphList.add(new Paragraph(line, matchResult));
            }
        }
        // 匹配到返回当前news
        if (allmatchFlag) {
            return new News(news.getNewsId(), news.getContext(), newParagraphList);
        }
        // 没有匹配到直接返回空对象
        return null;
    }
}
