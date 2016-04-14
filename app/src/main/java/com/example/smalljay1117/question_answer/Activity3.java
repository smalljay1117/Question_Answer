package com.example.smalljay1117.question_answer;

import android.view.View;

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
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }
}
