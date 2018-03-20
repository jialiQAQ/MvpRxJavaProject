package com.example.jiali.myapplication.module.cupon.modelimpl;

import com.example.jiali.myapplication.module.cupon.contract.CuponContract;

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
    public void queryStringList(okhttp3.Call call) {

    }
}
