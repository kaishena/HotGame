package com.example.hotgame.interfaces;

import com.example.hotgame.entity.User;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegisterService  {
    @GET("register")
    Call<User> register(@Query("username" ) String username, @Query("password") String password);

}
