package com.example.smalljay1117.question_answer;

import android.app.Application;
import android.content.Context;

import com.example.smalljay1117.question_answer.model.UesrAnswers;

public class MyApp extends Application {

    private static Context context;
    private static UesrAnswers uesrAnswers;

    public static Context getContext() {
        return context;
    }

    public static UesrAnswers getUesrAnswers() {
        if (uesrAnswers == null) {
            uesrAnswers = new UesrAnswers(4);
        }
        return uesrAnswers;
    }

    public MyApp() {
        context = this;
    }
}
