package com.sujan.quizlab.api.services;

import com.sujan.quizlab.api.request.LoginReq;
import com.sujan.quizlab.api.request.SignUpReq;
import com.sujan.quizlab.api.response.LoginRes;
import com.sujan.quizlab.api.response.SignUpRes;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface IUserService {

    @Multipart
    @POST("register.php")
    Call<SignUpRes> signupUser(@Part("phone") RequestBody phone, @Part("password") RequestBody password);

    @Multipart
    @POST("login.php")
    Call<LoginRes> loginUser(@Part("phone") RequestBody phone, @Part("password") RequestBody password);



}
