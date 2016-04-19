package com.example.smalljay1117.question_answer.model;

public class UesrAnswers {
    private char[] answers;
    private CharSequence[] descriptions;

    public UesrAnswers(int questionCount) {
        answers = new char[questionCount];
        descriptions = new CharSequence[questionCount];
    }

    public void setAnswers(int index, char answer, CharSequence description) {
        answers[index] = answer;
        descriptions[index] = description;
    }

    public char getAnswers(int index) {
        return answers[index];
    }

    public CharSequence getDescriptions(int index) {
        return descriptions[index];
    }
}
