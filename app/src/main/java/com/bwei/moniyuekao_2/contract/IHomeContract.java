package com.bwei.moniyuekao_2.contract;

import com.bwei.moniyuekao_2.base.mvp.IBaseModel;
import com.bwei.moniyuekao_2.base.mvp.IBaseView;
import com.bwei.moniyuekao_2.model.entity.ProductEntity;

public interface IHomeContract {

    interface IModel extends IBaseModel {
        void getPoroductdata(String url,IModelCallback iModelCallback);
        void getFlowdata(String url,IModelCallback iModelCallback);
        interface IModelCallback{
            void succsee(Object data);
            void error(Throwable throwable);
        }
    }
    interface  IView extends IBaseView {
        void succsee(Object data);
        void error(Throwable throwable);

    }
    interface IPresent{
        void getPoroductdata(String url);
        void getFlowdata(String url);
    }




}
