package com.example.jiali.myapplication.module.cupon.presenter;

import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.module.cupon.modelimpl.CuponModelImpl;

import java.io.IOException;

import okhttp3.Request;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponPresenter implements CuponContract.Presenter {

    private CuponModelImpl cuponModelImpl;

    private CuponContract.View view;

    public CuponPresenter(CuponContract.View view) {
        this.view = view;
    }

    @Override
    public void queryStringFromServer(String request) {
        cuponModelImpl.queryStringList(new okhttp3.Call() {
            @Override
            public Request request() {
                return null;
            }

            @Override
            public okhttp3.Response execute() throws IOException {
                return null;
            }

            @Override
            public void enqueue(okhttp3.Callback responseCallback) {

            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public okhttp3.Call clone() {
                return null;
            }
        });
    }

    @Override
    public void destory() {

    }

    @Override
    public void start() {
        cuponModelImpl = CuponModelImpl.getInstance();
    }
}
