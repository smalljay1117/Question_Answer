package com.example.smalljay1117.question_answer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.example.smalljay1117.question_answer.model.UesrAnswers;

public class Activity4 extends QuestionActivity {


    @Override
    protected void onStart() {
        super.onStart();
        setNextButtonText("Finish");
    }

    @Override
    public void next(View view) {
        QuestionAdapter adapter = QuestionAdapterFactory.getQuestionAdapter();
        UesrAnswers uesrAnswers = MyApp.getUesrAnswers();
        final StringBuilder message = new StringBuilder();

        message.append("您的作答如下\n\n");
        for (int i = 0; i < adapter.getQuestionCount(); i++) {
            message.append(String.valueOf(i + 1))
                    .append(": ")
                    .append(uesrAnswers.getAnswers(i))
                    .append("\n")
                    .append(uesrAnswers.getDescriptions(i))
                    .append("\n\n");
        }
        message.append("\n確定要結束？");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Activity4.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        QuestionActivity.resetQuestionIndex();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
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
    protected int getBackground() {
        return R.drawable.activity_4_4;
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
