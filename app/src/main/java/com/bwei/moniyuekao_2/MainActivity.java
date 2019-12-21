package com.bwei.moniyuekao_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bwei.moniyuekao_2.view.fragment.HomeFragment;
import com.bwei.moniyuekao_2.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewView();
        viewData();
    }

    private void viewData() {
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name","北京");
        otherFragment.setArguments(bundle);

        OtherFragment otherFragment1 = new OtherFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name","我的");
        otherFragment1.setArguments(bundle1);

        list = new ArrayList<>();
        list.add(homeFragment);
        list.add(otherFragment);
        list.add(otherFragment1);


        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private void viewView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_beijing:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_my:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });


    }
}
