package com.example.smalljay1117.question_answer;

import android.view.View;

public class Activity4 extends QuestionActivity {


    @Override
    protected void onStart() {
        super.onStart();
        setNextButtonText("Finish");
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }

    @Override
    protected Class getBackActivityClass() {
        return Activity3.class;
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
