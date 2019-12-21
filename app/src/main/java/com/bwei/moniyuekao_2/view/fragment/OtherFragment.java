package com.bwei.moniyuekao_2.view.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.moniyuekao_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_other,null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        tv.setText(name);
    }

    private void initView(View view) {
        tv = view.findViewById(R.id.tv);
    }


}
