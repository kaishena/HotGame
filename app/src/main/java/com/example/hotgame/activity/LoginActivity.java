package com.example.hotgame.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotgame.R;
import com.example.hotgame.view.InputView;

public class LoginActivity extends BaseActivity {
    private InputView mInputPhone, mInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        initNavBar(false, "登录HotGame", false);
        mInputPassword = findViewById(R.id.input_password);
        mInputPhone = findViewById(R.id.input_phone);

    }

    public void onRegisterClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);



    }

    public void onCommitClick(View v) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        //if(!UserUtils.validateLogin(this,phone,password)){
        //    return;

        //  }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
//        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//        LoginService loginService=retrofit.create(LoginService.class);
//        Call<User> call=loginService.login(phone,password);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                System.out.println("phonenumber:"+response.body().phoneNumber);
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
    }
}
