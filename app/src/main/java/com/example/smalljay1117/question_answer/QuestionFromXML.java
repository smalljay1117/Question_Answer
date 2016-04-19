package com.example.smalljay1117.question_answer;

import java.util.List;

public class QuestionFromXML implements QuestionAdapter {

    private List<Question> list;

    public QuestionFromXML(List<Question> list) {
        this.list = list;
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        return list.get(index).getDescription();
    }

    @Override
    public CharSequence getQuestionOptionsA(int index) {
        return list.get(index).getOptionA();
    }

    @Override
    public CharSequence getQuestionOptionsB(int index) {
        return list.get(index).getOptionB();
    }

    @Override
    public CharSequence getQuestionOptionsC(int index) {
        return list.get(index).getOptionC();
    }

    @Override
    public int getBackground(int index) {
        return list.get(index).getBackground();
    }
}
