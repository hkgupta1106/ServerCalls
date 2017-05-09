package com.example.himanshu.servercalls.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.himanshu.servercalls.R;
import com.example.himanshu.servercalls.activity.MainActivity;
import com.example.himanshu.servercalls.model.UserData;

/**
 * Created by himanshu on 6/5/17.
 */

public class SingleUserDataFragment extends Fragment {

    TextView tvName, tvId, tvUserName, tvEmail, tvStreet, tvSuite, tvCity, tvZipcode, tvLat, tvLang;
    Button btnShowPost;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_user_data,null);

        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvId = (TextView) view.findViewById(R.id.tv_id);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvStreet = (TextView) view.findViewById(R.id.tv_street);
        tvSuite = (TextView) view.findViewById(R.id.tv_suite);
        tvCity = (TextView) view.findViewById(R.id.tv_city);
        tvZipcode = (TextView) view.findViewById(R.id.tv_zipcode);
        tvLat = (TextView) view.findViewById(R.id.tv_lat);
        tvLang = (TextView) view.findViewById(R.id.tv_lang);
        btnShowPost = (Button) view.findViewById(R.id.btn_show_post);


        Bundle bundle = getArguments();
        final UserData userData = bundle.getParcelable("key");
        tvName.setText(userData.getName());
        tvId.setText(String.valueOf(userData.getId()));
        tvUserName.setText(userData.getUsername());
        tvEmail.setText(userData.getEmail());
        tvStreet.setText(userData.getAddress().getStreet());
        tvSuite.setText(userData.getAddress().getSuite());
        tvCity.setText(userData.getAddress().getCity());
        tvZipcode.setText(userData.getAddress().getZipcode());
        tvLat.setText(userData.getAddress().getGeo().getLat());
        tvLang.setText(userData.getAddress().getGeo().getLng());

        btnShowPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                FragmentManager fm = ((MainActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fllayout,new PostDataFragment(userData.getId()));
                ft.commit();
            }
        });


        return view;
    }
}
