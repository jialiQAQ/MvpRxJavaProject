package com.example.jiali.myapplication.module.cupon.contract;

import com.example.jiali.myapplication.module.BasePresenter;
import com.example.jiali.myapplication.module.BaseView;

import java.util.List;

import okhttp3.Call;

/**
 * Created by jiali on 2018/3/20.
 */

public interface CuponContract {
    interface View extends BaseView<Presenter> {
        void showStringList(List<String> list);
    }

    interface Presenter extends BasePresenter {
        void queryStringFromServer(String request);

    }

    interface Model {
        void queryStringList(Call call);
    }
}
