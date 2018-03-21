package com.example.jiali.myapplication;

import android.util.Log;

import com.example.jiali.myapplication.module.BaseActivity;
import com.example.jiali.myapplication.network.BaseObserver;
import com.example.jiali.myapplication.network.RxSchedulers;
import com.example.jiali.myapplication.network.conveter.RetrofitFactory;
import com.example.jiali.myapplication.network.requestbean.LoginRequest;
import com.example.jiali.myapplication.network.responsebean.BaseResponse;
import com.example.jiali.myapplication.network.responsebean.UserData;

import rx.Observable;


/**
 * @author jiali
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        LoginRequest request = new LoginRequest("admin", "123456");
        Observable<BaseResponse<UserData>> observable = RetrofitFactory.createService().login(request);
        observable.compose(RxSchedulers.<BaseResponse<UserData>>compose()).subscribe(new BaseObserver<UserData>() {
            @Override
            protected void onHandleSuccess(UserData userData) {
                Log.e("jiali", "initData success");
            }
        });
    }

}
