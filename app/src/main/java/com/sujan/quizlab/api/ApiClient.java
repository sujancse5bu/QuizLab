package com.sujan.quizlab.api;

import com.sujan.quizlab.api.services.IUserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://salahrand.me/quiz-api-cse5-bu/api/")
                .client(okHttpClient)
                .build();


        return retrofit;
    }


    public static IUserService getUserService() {
        IUserService userService = getRetrofit().create(IUserService.class);
        return userService;
    }
}
