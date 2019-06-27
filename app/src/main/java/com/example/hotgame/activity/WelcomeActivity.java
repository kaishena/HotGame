package com.example.hotgame.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hotgame.R;


import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();

    }
    private  void  init(){
        mTimer =new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {tologin();

            }
        }, 3*1000);
    }
    private void tomain(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void tologin(){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
