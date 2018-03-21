package com.example.jiali.myapplication.module.cupon.modelimpl;

import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.network.BaseObserver;

import java.util.List;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponModelImpl implements CuponContract.Model {

    private static CuponModelImpl instance;

    private CuponModelImpl() {
    }

    public static CuponModelImpl getInstance() {
        if (instance == null) {
            synchronized (CuponModelImpl.class) {
                if (instance == null) {
                    instance = new CuponModelImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public void queryStringList(BaseObserver<List<String>> observer) {
//        Observable<BaseResponse<List<String>>> observable = RetrofitFactory.createService().login(new LoginRequest("", ""));
//        observable.compose(RxSchedulers.<BaseResponse<List<String>>>compose()).subscribe(observer);
    }

    @Override
    public void clear() {

    }

}
