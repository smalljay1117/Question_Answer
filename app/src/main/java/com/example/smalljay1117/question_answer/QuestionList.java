package com.example.smalljay1117.question_answer;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class QuestionList {
    @ElementList
    private List<Question> list;

    public List<Question> getList() {
        return list;
    }
}
