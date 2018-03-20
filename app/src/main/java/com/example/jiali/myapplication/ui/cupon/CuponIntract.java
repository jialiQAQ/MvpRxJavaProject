package com.example.jiali.myapplication.ui.cupon;

import com.example.jiali.myapplication.ui.BasePresenter;
import com.example.jiali.myapplication.ui.BaseView;

import java.util.List;

/**
 * Created by jiali on 2018/3/20.
 */

public interface CuponIntract {
    interface View extends BaseView<Presenter> {
        void showStringList(List<String> list);

    }

    interface Presenter extends BasePresenter {
        void queryStringFromServer(String request);

        void onDestory();
    }
}
