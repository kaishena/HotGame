package com.example.hotgame.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotgame.R;

public class BaseActivity extends AppCompatActivity{
    private TextView mTvTitle;
    private ImageView mIvBack,mIvme;
    protected void initNavBar(boolean isShowBack,String Title,boolean isShowMe)
    {
        mIvBack=findViewById(R.id.iv_back);
        mIvme=findViewById(R.id.iv_me);
        mTvTitle=findViewById(R.id.tv_title);
        mIvBack.setVisibility(isShowBack? View.VISIBLE:View.GONE);
        mIvme.setVisibility(isShowMe? View.VISIBLE:View.GONE);
        mTvTitle.setText(Title);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mIvme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(BaseActivity.this,MeActivity.class));

            }
        });



    }
}
