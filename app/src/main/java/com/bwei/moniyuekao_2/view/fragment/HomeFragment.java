package com.bwei.moniyuekao_2.view.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.moniyuekao_2.R;
import com.bwei.moniyuekao_2.base.BaseFragment;
import com.bwei.moniyuekao_2.contract.IHomeContract;
import com.bwei.moniyuekao_2.model.adapter.HomeAdapter;
import com.bwei.moniyuekao_2.model.entity.FlowEntity;
import com.bwei.moniyuekao_2.model.entity.ProductEntity;
import com.bwei.moniyuekao_2.presenter.HomePresenter;
import com.bwei.moniyuekao_2.widght.FlowLayout;

import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    private EditText et;
    private Button bt_search;
    private FlowLayout flowLaout;
    private RecyclerView rv;
    @Override
    protected void initView(View view) {
         et = view.findViewById(R.id.et);
        bt_search = view.findViewById(R.id.bt_search);
        flowLaout = view.findViewById(R.id.flowLaout);
        flowLaout = view.findViewById(R.id.rv);

        //点击流式布局的tag,请求接口
        flowLaout.setFlowCallback(new FlowLayout.FlowCallback() {
            @Override
            public void flowClick(String name) {
                String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+ URLEncoder.encode(name) +"&page=1&count=5";

                presenter.getPoroductdata(url);
            }
        });

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判空
                if (TextUtils.isEmpty(et.getText().toString())){
                    Toast.makeText(getActivity(), "输入不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                flowLaout.addTextView(et.getText().toString());

                String url="172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(et.getText().toString())+"&page=1&count=5";
                presenter.getPoroductdata(url);

            }
        });



    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        String url="http://blog.zhaoliang5156.cn/baweiapi/"+URLEncoder.encode("手机");
        presenter.getFlowdata(url);
    }

    @Override
    public void succsee(Object data) {
        if (data instanceof FlowEntity){
            FlowEntity flowEntity= (FlowEntity) data;
            flowLaout.add(flowEntity.getTags());
        }else if (data instanceof ProductEntity){
            ProductEntity productEntity= (ProductEntity) data;
            HomeAdapter homeAdapter = new HomeAdapter(getContext(),productEntity.getResult());
            rv.setAdapter(homeAdapter);
            //接收接口传归来的数据
            homeAdapter.setRvItemClick(new HomeAdapter.RvItemClick() {
                @Override
                public void onclick(String name) {
                    Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
                    //跳转
                }
            });


        }
    }

    @Override
    public void error(Throwable throwable) {

        //失败
        Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
