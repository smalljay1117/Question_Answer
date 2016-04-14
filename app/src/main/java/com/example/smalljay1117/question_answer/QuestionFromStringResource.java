package com.example.smalljay1117.question_answer;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class QuestionFromStringResource implements QuestionAdapter {

    private List<Question> list = new ArrayList<>();

    public QuestionFromStringResource(Resources res) {
        list.add(new Question(res.getString(R.string.question_1),
                        res.getString(R.string.question_1_radio_a),
                        res.getString(R.string.question_1_radio_b),
                        res.getString(R.string.question_1_radio_c),
                        R.drawable.activity_1_1)
        );
        list.add(new Question(res.getString(R.string.question_2),
                        res.getString(R.string.question_2_radio_a),
                        res.getString(R.string.question_2_radio_b),
                        res.getString(R.string.question_2_radio_c),
                        R.drawable.activity_2_2)
        );
        list.add(new Question(res.getString(R.string.question_3),
                        res.getString(R.string.question_3_radio_a),
                        res.getString(R.string.question_3_radio_b),
                        res.getString(R.string.question_3_radio_c),
                        R.drawable.activity_3_3)
        );
        list.add(new Question(res.getString(R.string.question_4),
                        res.getString(R.string.question_4_radio_a),
                        res.getString(R.string.question_4_radio_b),
                        res.getString(R.string.question_4_radio_c),
                        R.drawable.activity_4_4)
        );
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        Question question = list.get(index);
        String text = question.getQuestion();
        return text;
    }

    @Override
    public CharSequence getQuestionOptionsA(int index) {
        return list.get(index).getOptionA();
    }

    @Override
    public CharSequence getQuestionOptionsB(int index) {
        return list.get(index).getOptionB();
    }

    @Override
    public CharSequence getQuestionOptionsC(int index) {
        return list.get(index).getOptionC();
    }

    @Override
    public int getBackground(int index) {
        return list.get(index).getBackground();
    }
}
