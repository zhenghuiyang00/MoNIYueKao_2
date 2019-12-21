package com.bwei.moniyuekao_2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bwei.moniyuekao_2.base.mvp.BasePresenter;
import com.bwei.moniyuekao_2.base.mvp.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();
        //创建一个
        presenter=initPresenter();
        if(presenter!=null){
            presenter.attach(this);
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int layoutId();


    /**
     * 内存泄漏
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettach();
        }
    }
}
