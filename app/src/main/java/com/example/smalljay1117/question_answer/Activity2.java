package com.example.smalljay1117.question_answer;

import android.view.View;

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
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }
}
