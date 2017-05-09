package com.example.himanshu.servercalls.service;

import com.example.himanshu.servercalls.model.SingleUserData;
import com.example.himanshu.servercalls.model.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by himanshu on 4/5/17.
 */

public interface ApiInterface {

    public String SUB_URL = "users";
    public String sub_url = "posts";

    @GET(SUB_URL)
    Call<List<UserData>> getUserData();

    @GET(sub_url)
    Call<List<SingleUserData>> getSingleUserData(@Query("userId") int userId);
}
