package com.example.jiali.myapplication.ui.cupon;

import java.util.List;

import retrofit2.Call;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponRepository implements ICurdActionListener {

    private static CuponRepository instance;

    private CuponRepository() {
    }

    public static ICurdActionListener getInstance() {
        if (instance == null) {
            synchronized (CuponRepository.class) {
                if (instance == null) {
                    instance = new CuponRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public List<String> queryStringList(Call call) {
        return null;
    }
}
