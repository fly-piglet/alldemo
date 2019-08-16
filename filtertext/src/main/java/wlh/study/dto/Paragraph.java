package wlh.study.dto;

import java.util.HashSet;
import java.util.Set;

public class Paragraph {
    private String paragraph;
    private Set<String> matchResult;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        this.matchResult = new HashSet<>();
    }

    public Paragraph(String paragraph, Set<String> matchResult) {
        this.paragraph = paragraph;
        this.matchResult = matchResult;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Set<String> getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(Set<String> matchResult) {
        this.matchResult = matchResult;
    }
}
