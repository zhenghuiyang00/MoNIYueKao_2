package com.bwei.moniyuekao_2.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bwei.moniyuekao_2.R;
import com.bwei.moniyuekao_2.model.entity.ProductEntity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context context;
    private List<ProductEntity.ResultBean>list;

    public HomeAdapter(Context context, List<ProductEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv.setText(list.get(position).getCommodityName());
        Glide.with(context).load(list.get(position).getPrice())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .circleCrop()
                .into(holder.iv);
        //点击事件，通过下面声明的接口，发送商品标题
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvItemClick.onclick(list.get(position).getCommodityName());
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private  ImageView iv;
        private  TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);

        }
    }


    //声明接口
    private RvItemClick rvItemClick;

    public void setRvItemClick(RvItemClick rvItemClick) {
        this.rvItemClick = rvItemClick;
    }
    public interface RvItemClick{
        void onclick(String name);
    }
}
