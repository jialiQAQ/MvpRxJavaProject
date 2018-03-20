package com.example.jiali.myapplication.ui.cupon;

import java.util.List;

import retrofit2.Call;

/**
 * Created by jiali on 2018/3/20.
 */

public interface ICurdActionListener {
    List<String> queryStringList(Call call);
}
