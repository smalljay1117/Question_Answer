package com.example.smalljay1117.question_answer;

public class Activity3 extends QuestionActivity {

    @Override
    protected Class getNextActivityClass() {
        return Activity4.class;
    }

    @Override
    protected Class getBackActivityClass() {
        return Activity2.class;
    }

    @Override
    protected int getBackground() {
        return R.drawable.activity_3_3;
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
