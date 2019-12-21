package com.bwei.moniyuekao_2.widght;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.moniyuekao_2.R;

import java.util.List;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left=0;
        int top=0;
        int right=0;
        int bottom=0;

        int count = getChildCount();

        if (count>0){
            for (int i = 0; i <count; i++) {
                View view = getChildAt(i);
                view.measure(0,0);
                int childWidth = view.getMeasuredWidth();
                int childHeight = view.getMeasuredHeight();

                right=left+childWidth;

                int widthPixels = getResources().getDisplayMetrics().widthPixels;

                if (right>widthPixels){
                    left=0;
                    right=left+childWidth;
                    top=bottom+30;
                 }

                bottom=top+childHeight;

                view.layout(left,top,right,bottom);

                left+=childWidth+30;

            }
        }

    }

    public void add(List<String> tags){
        if (tags!=null && tags.size()>0){
            for(String tag:tags){
                final TextView textView = new TextView(getContext());
                textView.setBackgroundResource(R.drawable.flow_bj);
                textView.setText(tag);
                //添加当前流式布局中
                addView(textView);

                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flowCallback.flowClick(textView.getText().toString());
                    }
                });


            }
        }
    }

    public void addTextView(String name){
        final TextView textView = new TextView(getContext());
        textView.setBackgroundResource(R.drawable.flow_bj);
        textView.setText(name);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                flowCallback.flowClick(textView.getText().toString());
            }
        });
        addView(textView);
    }



    //回调接口
    //声明
    private FlowCallback flowCallback;

    public void setFlowCallback(FlowCallback flowCallback) {
        this.flowCallback = flowCallback;
    }

    public interface FlowCallback{
        void flowClick(String name);
    }

}
