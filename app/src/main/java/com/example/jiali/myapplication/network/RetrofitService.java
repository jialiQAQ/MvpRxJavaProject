package com.example.jiali.myapplication.network;

import com.example.jiali.myapplication.network.requestbean.LoginRequest;
import com.example.jiali.myapplication.network.responsebean.BaseResponse;
import com.example.jiali.myapplication.network.responsebean.UserData;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jiali on 2018/3/19.
 */

public interface RetrofitService {

    @POST("/kspos/merchant/login")
    Observable<BaseResponse<UserData>> login(@Body LoginRequest loginRequest);
}
