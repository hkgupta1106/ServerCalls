package com.example.himanshu.servercalls.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.himanshu.servercalls.R;
import com.example.himanshu.servercalls.fragment.SingleUserDataFragment;
import com.example.himanshu.servercalls.fragment.UserDataFragment;
import com.example.himanshu.servercalls.service.ApiInterface;

import com.example.himanshu.servercalls.model.UserData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_layout,new UserDataFragment());
        ft.commit();

    }
}
