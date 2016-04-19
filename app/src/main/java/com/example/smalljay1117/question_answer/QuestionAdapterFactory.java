package com.example.smalljay1117.question_answer;

import android.content.res.Resources;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class QuestionAdapterFactory {

    public interface CallBack {
        void receiveQuestionAdapter(QuestionAdapter adapter);
    }

    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter() {
        if (adapter == null) {
            Resources res = MyApp.getContext().getResources();
//            adapter = new QuestionFromStringResource(res);
            try {
                adapter = new QuestionFromRawXml(res);
            } catch (Exception e) {
                Log.d("factory", e.toString());
            }
        }
        return adapter;
    }

    public static void getQuestionAdapter(CallBack callBack) {
        loadFromGoogleDrive(callBack);
    }

    private static void loadFromGoogleDrive(final CallBack callBack) {
        QuestionListService service = QuestionListService.retrofit.create(QuestionListService.class);
        Call<QuestionList> call = service.getQuestionList();

        call.enqueue(new retrofit2.Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                if (response.isSuccessful()) {
                    Log.d("Retrofit", "onResponse() success");
                    QuestionList ql = response.body();
                    List<Question> list = ql.getList();
                    adapter = new QuestionFromXML(list);
                    callBack.receiveQuestionAdapter(adapter);
                } else {
                    Log.d("Retrofit", "onResponse() : error response, no access to resource ?");
                }
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Log.d("Retrofit", "onFailure() :" + t.toString());
            }
        });
    }


    public QuestionAdapterFactory() {

    }
}
