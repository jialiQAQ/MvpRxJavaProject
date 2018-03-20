package com.example.jiali.myapplication.network;

import com.bbit.catering.bean.UserData;
import com.example.jiali.myapplication.network.responsebean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jiali on 2018/3/19.
 */

public interface RetrofitService {
    @FormUrlEncoded
    @POST("merchant/login")
    Call<BaseResponse<UserData>> login(@Field("email") String account, @Field("password") String password);
}
