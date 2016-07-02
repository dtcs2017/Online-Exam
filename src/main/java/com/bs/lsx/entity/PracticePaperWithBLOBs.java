package com.bs.lsx.entity;

public class PracticePaperWithBLOBs extends PracticePaper {
    private String content;

    private String answerSheet;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAnswerSheet() {
        return answerSheet;
    }

    public void setAnswerSheet(String answerSheet) {
        this.answerSheet = answerSheet == null ? null : answerSheet.trim();
    }
}