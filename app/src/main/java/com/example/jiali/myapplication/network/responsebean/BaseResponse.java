package com.example.jiali.myapplication.network.responsebean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiali on 2018/3/19.
 */

public class BaseResponse<T> {
    @SerializedName("code")
    private String code;
    @SerializedName("data")
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
