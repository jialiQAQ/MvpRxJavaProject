package com.example.jiali.myapplication.module.cupon.presenter;

import com.example.jiali.myapplication.module.BaseModel;
import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.module.cupon.modelimpl.CuponModelImpl;
import com.example.jiali.myapplication.network.BaseObserver;

import java.util.List;


/**
 * Created by jiali on 2018/3/20.
 */

public class CuponPresenter extends CuponContract.Presenter {

    private CuponModelImpl cuponModelImpl = CuponModelImpl.getInstance();

    private CuponContract.View view;

    public CuponPresenter(CuponContract.View view) {
        super(view);
        this.view = view;
    }

    @Override
    public void queryStringFromServer(String string) {
        cuponModelImpl.queryStringList(baseObserver);
        register(baseObserver);
    }

    private BaseObserver<List<String>> baseObserver = new BaseObserver<List<String>>() {
        @Override
        protected void onHandleSuccess(List<String> list) {
        }

    };

    @Override
    protected BaseModel createModel() {
        return CuponModelImpl.getInstance();
    }
}
