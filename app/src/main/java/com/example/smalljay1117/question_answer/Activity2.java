package com.example.smalljay1117.question_answer;

public class Activity2 extends QuestionActivity {

    @Override
    protected Class getNextActivityClass() {
        return Activity3.class;
    }

    @Override
    protected Class getBackActivityClass() {
        return Activity1.class;
    }

    @Override
    protected int getBackground() {
        return R.drawable.activity_2_2;
    }

    @Override
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }
}
