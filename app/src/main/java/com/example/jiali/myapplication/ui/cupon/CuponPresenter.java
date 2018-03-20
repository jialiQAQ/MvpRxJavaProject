package com.example.jiali.myapplication.ui.cupon;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponPresenter implements CuponIntract.Presenter {

    private ICurdActionListener curdActionListener;

    private CuponIntract.View view;

    public CuponPresenter(CuponIntract.View view) {
        this.view = view;
    }

    @Override
    public void queryStringFromServer(String request) {
        curdActionListener.queryStringList(new Call() {
            @Override
            public Response execute() throws IOException {
                return null;
            }

            @Override
            public void enqueue(Callback callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        });
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void start() {
        curdActionListener = CuponRepository.getInstance();
    }
}
