package com.example.hotgame.frgment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;


import com.example.hotgame.MyFragment;
import com.example.hotgame.R;
import com.example.hotgame.adapter.FragmentAdapter;


import java.util.ArrayList;
import java.util.List;


public class RankFrgment extends Fragment implements View.OnClickListener{
    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button bt1,bt2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_rank,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.vp);



        list=new ArrayList<>();
        list.add(new DownloadRankFrgment());
        list.add(new ScoreRankFragment());
        bt1=(Button)view.findViewById(R.id.bt1);
        bt2=(Button)view.findViewById(R.id.bt2);



        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt1.performClick();

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),list));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initBtnListener();
                switch (position){
                    case 0:
                        bt1.setTextColor(Color.parseColor("#16BCCA"));
                        break;
                    case 1:
                        bt2.setTextColor(Color.parseColor("#16BCCA"));
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        return view;
    }













    public void onClick(View v) {
        initBtnListener();
        switch (v.getId()){
            case R.id.bt1:
                bt1.setTextColor(Color.parseColor("#16BCCA"));
                viewPager.setCurrentItem(0);
                break;
            case R.id.bt2:
                bt2.setTextColor(Color.parseColor("#16BCCA"));
                viewPager.setCurrentItem(1);
                break;

        }
    }

    private void initBtnListener(){

        bt1.setTextColor(getResources().getColor(R.color.TitleColor));
        bt2.setTextColor(getResources().getColor(R.color.TitleColor));


    }
}



