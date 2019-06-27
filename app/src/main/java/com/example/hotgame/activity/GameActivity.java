package com.example.hotgame.activity;


import android.content.Intent;
import android.os.Bundle;

import com.example.hotgame.R;

public class GameActivity extends BaseActivity{
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();
    }
    public void initView(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
         name= bundle.getString("name");

        initNavBar(true,name,false);

    }
}
