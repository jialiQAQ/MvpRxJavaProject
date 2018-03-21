package com.example.jiali.myapplication.module.cupon.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jiali.myapplication.module.BaseActivity;
import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.module.cupon.presenter.CuponPresenter;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponActivity extends BaseActivity {

    private CuponContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CuponFragment cuponFragment = new CuponFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(cuponFragment, "");
        transaction.commit();
        getFragmentManager().executePendingTransactions();
        //所有的事件都在Fragment层进行处理，包括跟Fragment同级别的控件，使用getActvity.findViewById获取控件
        presenter = new CuponPresenter(cuponFragment);
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
