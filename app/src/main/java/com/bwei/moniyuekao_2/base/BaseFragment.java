package com.bwei.moniyuekao_2.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bwei.moniyuekao_2.base.mvp.BasePresenter;
import com.bwei.moniyuekao_2.base.mvp.IBaseView;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =View.inflate(getContext(),LayoutId(),null);
        initView(view);
        presenter=initPresenter();
        if (presenter!=null){
            //绑定
            presenter.attach(this);
        }
        return view;
    }

    protected abstract void initView(View view);

    protected abstract P initPresenter();

    protected abstract int LayoutId();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettach();
        }
    }
}
