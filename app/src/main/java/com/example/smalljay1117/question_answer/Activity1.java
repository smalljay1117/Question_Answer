package com.example.smalljay1117.question_answer;

public class Activity1 extends QuestionActivity {

    @Override
    protected Class getNextActivityClass() {
        return Activity2.class;
    }

    @Override
    protected Class getBackActivityClass() {
        return null;
    }

    @Override
    protected int getBackground() {
        return R.drawable.activity_1_1;
    }

    @Override
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.GONE;
    }


}
