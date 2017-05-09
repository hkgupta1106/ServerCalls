package com.example.himanshu.servercalls.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanshu.servercalls.R;
import com.example.himanshu.servercalls.adapter.SingleUserDataAdapter;
import com.example.himanshu.servercalls.model.SingleUserData;
import com.example.himanshu.servercalls.model.UserData;
import com.example.himanshu.servercalls.service.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by himanshu on 9/5/17.
 */

public class PostDataFragment extends Fragment {
    private int userId;

    public PostDataFragment(final int userId) {
        this.userId = userId;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_post_data, null);
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<SingleUserData>> call = apiInterface.getSingleUserData(userId);
        call.enqueue(new Callback<List<SingleUserData>>() {
            @Override
            public void onResponse(final Call<List<SingleUserData>> call, final Response<List<SingleUserData>> response) {

                List<SingleUserData> singleUserDatas = response.body();
                SingleUserDataAdapter displayadapter = new SingleUserDataAdapter(getContext(), singleUserDatas);

                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_layout);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(displayadapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(final Call<List<SingleUserData>> call, final Throwable t) {

            }
        });
        return view;
    }
}
