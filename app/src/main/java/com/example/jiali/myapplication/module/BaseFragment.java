package com.example.jiali.myapplication.module;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author jiali
 * @date 2018/3/20
 */

public abstract class BaseFragment extends DialogFragment implements BaseView {

    /**
     * Fragment的View加载完毕的标记
     */
    private boolean isViewCreated;

    /**
     * Fragment对用户可见的标记
     */
    private boolean isUIVisible;

    private BasePresenter presenter;

    private Unbinder unbinder;

    /**
     * 是否是首次加载数据
     */
    private boolean isFirst = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        isViewCreated = true;
        presenter = createPresenter();
        return view;
    }

    protected abstract int getLayoutResId();

    protected abstract void initView(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
    }

    private void lazyLoad() {
        if (isViewCreated && isUIVisible && isFirst) {
            initData();
            isFirst = false;
        }
    }

    protected abstract void initData();

    protected abstract BasePresenter createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unregister();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
