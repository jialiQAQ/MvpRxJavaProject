package com.example.jiali.myapplication.network;

import com.example.jiali.myapplication.network.responsebean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by jiali on 2018/3/19.
 */

public interface RetrofitService {

    @GET("..")
    Observable<BaseResponse<List<String>>> queryStringList();
}
