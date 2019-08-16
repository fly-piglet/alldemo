package wlh.study.biz.impl;

import wlh.study.biz.CheckAndReturnBiz;
import wlh.study.dto.News;
import wlh.study.dto.Paragraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ThirdCheckAndReturnBizImpl implements CheckAndReturnBiz {
    @Override
    public News firstCheckAndReturn(News news) {
        ArrayList<Paragraph> paragraphList = news.getParagraphList();
        ArrayList<Paragraph> newParagraphList = new ArrayList<>();

        Boolean allmatchFlag = false;
        for (Paragraph paragraph : paragraphList) {
            String line = paragraph.getParagraph();
            Set<String> matchResult = new HashSet<>();
            Boolean matchFlag = false;
            String[] matchString = new String[]{"董事长","董事局主席","法定代表人","实际控制人","总经理","总裁","CEO","财务总监"
                    ,"总会计师","总监","法人","税务总兼","总会","执行总裁","董秘","董事会秘书"};
            for (int i = 0; i < matchString.length; i++) {
                if (line.contains(matchString[i])) {
                    matchFlag = true;
                    allmatchFlag = true;
                    matchResult.add(matchString[i]);
                }
            }
            if (matchFlag) {
                newParagraphList.add(new Paragraph(line, matchResult));
            }
        }
        // 匹配到返回当前news
        if (allmatchFlag) {
            News returnNews = new News(news.getNewsId(), news.getContext(), newParagraphList);
            return returnNews;
        }
        // 没有匹配到直接返回空对象
        return null;
    }
}
