package com.example.smalljay1117.question_answer;

import android.content.res.Resources;

public class QuestionAdapterFactory {

    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter() {
        if (adapter == null) {
            Resources res = MyApp.getContext().getResources();
            adapter = new QuestionFromStringResource(res);
        }
        return adapter;
    }

    public QuestionAdapterFactory() {

    }
}
