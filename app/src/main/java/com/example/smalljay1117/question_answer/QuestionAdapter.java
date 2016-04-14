package com.example.smalljay1117.question_answer;

public interface QuestionAdapter {
    int getQuestionCount();
    CharSequence getQuestion(int index);
    CharSequence getQuestionOptionsA(int index);
    CharSequence getQuestionOptionsB(int index);
    CharSequence getQuestionOptionsC(int index);
    int getBackground(int index);
}
