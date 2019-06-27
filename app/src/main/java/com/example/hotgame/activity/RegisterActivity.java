package com.example.hotgame.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotgame.Constants;
import com.example.hotgame.R;
import com.example.hotgame.entity.User;
import com.example.hotgame.interfaces.RegisterService;
import com.example.hotgame.view.InputView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class RegisterActivity extends BaseActivity {
    private InputView mInput_username,mInput_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void  initView(){
        initNavBar(true,"注册HotGame",false);
       mInput_username=findViewById(R.id.input_username);
       mInput_password=findViewById(R.id.input_password);

    }
    public void onLoginClick(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);



    }
    public void onCommit(View v){
        String username=mInput_username.getInputStr();
        String password=mInput_password.getInputStr();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RegisterService registerService=retrofit.create(RegisterService.class);
        Call<User> call=registerService.register(username,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
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
