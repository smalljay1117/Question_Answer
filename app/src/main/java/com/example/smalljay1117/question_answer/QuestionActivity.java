package com.example.smalljay1117.question_answer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public abstract class QuestionActivity extends AppCompatActivity {

    private TextView m_tv_no;
    private TextView m_tv_question;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;
    private CharSequence m_answer;
    private LinearLayout m_background;

    private Button m_btn_next;
    private Button m_btn_back;

    private static int sQuestionIndex = 0;
    private static QuestionAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initQuestions();
        initBackNextButtons();
        Log.d(this.toString(), "onCreate , index = " + sQuestionIndex);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.toString(), "onCreate , index = " + sQuestionIndex);
    }

    @SuppressWarnings("ResourceType")
    private void initBackNextButtons() {
        m_btn_next = (Button) findViewById(R.id.btn_next);
        m_btn_back = (Button) findViewById(R.id.btn_back);

        m_btn_next.setVisibility(getNextButtonVisibility());
        m_btn_back.setVisibility(getBackButtonVisibility());
    }

    private void initQuestions() {
        m_tv_no = (TextView) findViewById(R.id.tv_no);
        m_tv_question = (TextView) findViewById(R.id.tv_question);
        m_radio_a = (RadioButton) findViewById(R.id.radio_a);
        m_radio_b = (RadioButton) findViewById(R.id.radio_b);
        m_radio_c = (RadioButton) findViewById(R.id.radio_c);
        m_background = (LinearLayout) findViewById(R.id.ll_background);

        String no = String.valueOf(sQuestionIndex + 1);
        m_tv_no.setText("第" + no + "題");

        if (sAdapter == null) {
            sAdapter = QuestionAdapterFactory.getQuestionAdapter();
        }

        m_tv_question.setText(sAdapter.getQuestion(sQuestionIndex));
        m_radio_a.setText(sAdapter.getQuestionOptionsA(sQuestionIndex));
        m_radio_b.setText(sAdapter.getQuestionOptionsB(sQuestionIndex));
        m_radio_c.setText(sAdapter.getQuestionOptionsC(sQuestionIndex));
        m_background.setBackgroundResource(sAdapter.getBackground(sQuestionIndex));
    }

    private static int sLastQuestionIndex;

    public void next(View view) {
        sLastQuestionIndex = sQuestionIndex;
        sQuestionIndex++;
        Intent intent = new Intent(this, getNextActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void back(View view) {
        sLastQuestionIndex = sQuestionIndex;
        sQuestionIndex--;
        Intent intent = new Intent(this, getBackActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.toString(), "onCreate , index = " + sQuestionIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.toString(), "onCreate , index = " + sQuestionIndex);
        if (sQuestionIndex < sLastQuestionIndex) {
            overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
        } else if (sQuestionIndex > sLastQuestionIndex) {
            overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
        }
    }

    public void setNextButtonText(CharSequence text) {
        m_btn_next.setText(text);
    }

    public void setBackButtonText(CharSequence text) {
        m_btn_back.setText(text);
    }

    public void click(View view) {

    }

    public void onBackPressed() {
        return;
    }

    protected abstract Class getNextActivityClass();

    protected abstract Class getBackActivityClass();

    protected abstract
    @Visibility
    int getNextButtonVisibility();

    protected abstract
    @Visibility
    int getBackButtonVisibility();

    public static final int VISIBLE = View.VISIBLE;
    public static final int INVISIBLE = View.INVISIBLE;
    public static final int GONE = View.GONE;

    @IntDef({VISIBLE, INVISIBLE, GONE})
    public @interface Visibility {

    }
}
