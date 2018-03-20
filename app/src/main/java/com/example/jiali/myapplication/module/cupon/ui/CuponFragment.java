package com.example.jiali.myapplication.module.cupon.ui;

import android.view.View;

import com.example.jiali.myapplication.module.BaseFragment;
import com.example.jiali.myapplication.module.cupon.contract.CuponContract;
import com.example.jiali.myapplication.module.cupon.presenter.CuponPresenter;

import java.util.List;

import rx.Subscriber;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponFragment extends BaseFragment implements CuponContract.View {
    private CuponPresenter presenter;

    @Override
    public void showStringList(List<String> list) {

    }

    @Override
    public void setPresenter(CuponContract.Presenter presenter) {
        this.presenter = (CuponPresenter) presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
        presenter.queryStringFromServer("..");
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
