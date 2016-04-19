package com.example.smalljay1117.question_answer;

import android.content.res.Resources;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuestionFromRawXml implements QuestionAdapter {

    List<Question> list = new ArrayList<>();

    private int[] img = {R.drawable.activity_1_1, R.drawable.activity_2_2, R.drawable.activity_3_3, R.drawable.activity_4_4};

    public QuestionFromRawXml(Resources res) throws XmlPullParserException, IOException {
        InputStream is = res.openRawResource(R.raw.questions);
        list = parse(is);
    }

    private List<Question> parse(InputStream is) throws XmlPullParserException, IOException {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(is, "UTF-8");
            xpp.nextTag();

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < img.length; i++) {
            int a = img[i];
            list1.add(a);
        }

        xpp.require(XmlPullParser.START_TAG, null, "Exams");
        while (xpp.nextTag() == XmlPullParser.START_TAG) {
            xpp.require(XmlPullParser.START_TAG, null, "Exam");

            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "Question");
            String question = xpp.nextText();
            Log.d("question", question);
            xpp.require(XmlPullParser.END_TAG, null, "Question");

            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionA");
            String optionA = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionA");

            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionB");
            String optionB = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionB");

            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionC");
            String optionC = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionC");

            xpp.nextTag();
            xpp.require(XmlPullParser.END_TAG, null, "Exam");

            list.add(new Question(question, optionA, optionB, optionC));
        }
        return list;
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        return list.get(index).getDescription();
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
