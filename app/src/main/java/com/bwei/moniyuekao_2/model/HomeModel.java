package com.bwei.moniyuekao_2.model;

import com.bwei.moniyuekao_2.contract.IHomeContract;
import com.bwei.moniyuekao_2.model.entity.FlowEntity;
import com.bwei.moniyuekao_2.model.entity.ProductEntity;
import com.bwei.moniyuekao_2.utils.VolleyUtils;
import com.google.gson.Gson;


public class HomeModel implements IHomeContract.IModel{


    @Override
    public void getPoroductdata(String url, final IModelCallback iModelCallback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                //解析
                ProductEntity productEntity = new Gson().fromJson(response, ProductEntity.class);
                iModelCallback.succsee(productEntity);
            }

            @Override
            public void failure(Throwable error) {
                iModelCallback.error(error);

            }
        });
    }

    @Override
    public void getFlowdata(String url, final IModelCallback iModelCallback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                FlowEntity flowEntity = new Gson().fromJson(response, FlowEntity.class);
                iModelCallback.succsee(flowEntity);
            }

            @Override
            public void failure(Throwable error) {
                iModelCallback.error(error);
            }
        });
    }
}
