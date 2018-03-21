package com.example.jiali.myapplication.network;

import android.util.Log;

import com.example.jiali.myapplication.network.responsebean.BaseResponse;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by jiali on 2017/7/13.
 */

public abstract class BaseObserver<T> extends DisposableObserver<BaseResponse<T>> {

    private static final String TAG = "BaseObserver";


    @Override
    public void onNext(BaseResponse<T> value) {
//        if (value.isSuccess() || value.getCode() == 1) {
//                T t = value.getData();
//            if (t == null) {
//                onHandleSuccess(value.getBody());
//            } else {
//                onHandleSuccess(t);
//            }
//
//        } else if () {
//        } else {
//            onHandleError(value.getMessage());
//        }
        onHandleSuccess(value.getData());
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }


    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
    }
}
