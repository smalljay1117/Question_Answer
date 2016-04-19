package com.example.smalljay1117.question_answer;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

public interface QuestionListService {
    @GET("/uc?export=download&id=0B4utjO1RNc-0dW82dmlRbmY0UXM")
    Call<QuestionList> getQuestionList();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://drive.google.com/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
}
