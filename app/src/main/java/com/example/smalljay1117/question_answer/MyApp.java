package com.example.smalljay1117.question_answer;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    public MyApp() {
        context = this;
    }
}
