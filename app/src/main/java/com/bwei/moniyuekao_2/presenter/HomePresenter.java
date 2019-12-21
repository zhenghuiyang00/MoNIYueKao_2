package com.bwei.moniyuekao_2.presenter;

import com.bwei.moniyuekao_2.base.mvp.BasePresenter;
import com.bwei.moniyuekao_2.contract.IHomeContract;
import com.bwei.moniyuekao_2.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresent {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getPoroductdata(String url) {
        model.getPoroductdata(url, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void succsee(Object data) {
                getView().succsee(data);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    public void getFlowdata(String url) {
        model.getFlowdata(url, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void succsee(Object data) {
                getView().succsee(data);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }
}
