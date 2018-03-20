package com.example.jiali.myapplication.ui.cupon;

import com.example.jiali.myapplication.ui.BaseFragment;

import java.util.List;

/**
 * Created by jiali on 2018/3/20.
 */

public class CuponFragment extends BaseFragment implements CuponIntract.View {
    private CuponPresenter presenter;

    @Override
    public void showStringList(List<String> list) {

    }

    @Override
    public void setPresenter(CuponIntract.Presenter presenter) {
        this.presenter = (CuponPresenter) presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
        presenter.queryStringFromServer("..");
    }
}
