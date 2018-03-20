package com.example.jiali.myapplication.ui.cupon;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jiali.myapplication.ui.BaseActivity;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponActivity extends BaseActivity {

    private CuponIntract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CuponFragment cuponFragment = new CuponFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(cuponFragment, "");
        transaction.commit();
        //所有的事件都在Fragment层进行处理，包括跟Fragment同级别的控件，使用getActvity.findViewById获取控件
        presenter = new CuponPresenter(cuponFragment);
    }
}
