package com.example.jiali.myapplication.module.cupon.contract;

import com.example.jiali.myapplication.module.BaseModel;
import com.example.jiali.myapplication.module.BasePresenter;
import com.example.jiali.myapplication.module.BaseView;
import com.example.jiali.myapplication.network.BaseObserver;

import java.util.List;

/**
 * Created by jiali on 2018/3/20.
 */

public abstract class CuponContract {
    public interface View extends BaseView {
        void showStringList(List<String> list);
    }

    public static abstract class Presenter extends BasePresenter {
        protected Presenter(BaseView baseView) {
            super(baseView);
        }

        public abstract void queryStringFromServer(String request);
    }

    public interface Model extends BaseModel {
        void queryStringList(BaseObserver<List<String>> observer);
    }
}
