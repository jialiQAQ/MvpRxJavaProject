package com.example.jiali.myapplication.module.cupon.modelimpl;

import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.network.BaseObserver;
import com.example.jiali.myapplication.network.RxSchedulers;
import com.example.jiali.myapplication.network.conveter.RetrofitFactory;
import com.example.jiali.myapplication.network.responsebean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;

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
        Observable<BaseResponse<List<String>>> observable = RetrofitFactory.createService().queryStringList();
        observable.compose(RxSchedulers.<BaseResponse<List<String>>>compose()).subscribe(observer);
    }

    @Override
    public void clear() {

    }

}
