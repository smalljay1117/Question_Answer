package com.example.smalljay1117.question_answer;

public class Question {
    private String description;
    private String optionA;
    private String optionB;
    private String optionC;
    private int background;

    public Question(String question, String optionA, String optionB, String optionC) {
        this.description = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
//        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public int getBackground() {
        return background;
    }
}
