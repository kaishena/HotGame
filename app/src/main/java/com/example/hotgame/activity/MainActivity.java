package com.example.hotgame.activity;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hotgame.MyFragment;
import com.example.hotgame.R;
import com.example.hotgame.frgment.HomeFrgment;
import com.example.hotgame.frgment.RankFrgment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_tab_bar;
    private RadioButton rb_home;

    //Fragment Object
    private MyFragment fg2,fg4;
    private HomeFrgment homeFrgment;
    private RankFrgment rankFrgment;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fManager= getSupportFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_home.setChecked(true);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.rb_home:
                initNavBar(false,"HotGame",true);


                if(homeFrgment == null){
                    homeFrgment=new HomeFrgment();


                    fTransaction.add(R.id.ly_content,homeFrgment);
                }else{
                    fTransaction.show(homeFrgment);
                }
                break;
            case R.id.rb_find:

                if(fg2 == null){
                    fg2 = new MyFragment();
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_rank:
                if(rankFrgment == null){
                    rankFrgment = new RankFrgment();
                    fTransaction.add(R.id.ly_content,rankFrgment);
                }else{
                    fTransaction.show(rankFrgment);
                }
                break;
            case R.id.rb_my_game:
                if(fg4 == null){
                    fg4 = new MyFragment();
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(homeFrgment != null)fragmentTransaction.hide(homeFrgment);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(rankFrgment != null)fragmentTransaction.hide(rankFrgment);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }




}
