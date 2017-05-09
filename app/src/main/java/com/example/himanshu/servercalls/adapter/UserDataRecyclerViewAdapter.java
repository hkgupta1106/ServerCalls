package com.example.himanshu.servercalls.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.servercalls.R;
import com.example.himanshu.servercalls.activity.MainActivity;
import com.example.himanshu.servercalls.fragment.SingleUserDataFragment;
import com.example.himanshu.servercalls.model.UserData;

import java.util.List;

import retrofit2.Call;

/**
 * Created by himanshu on 6/5/17.
 */

public class UserDataRecyclerViewAdapter extends RecyclerView.Adapter<UserDataRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<UserData> userDatas;
    UserData userData;

    public UserDataRecyclerViewAdapter(final Context context, final List<UserData> userDatas) {
        this.context = context;
        this.userDatas = userDatas;
    }

    @Override
    public UserDataRecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_user_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        /**
         * return view holder
         */
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        userData = userDatas.get(position);
        holder.tvName.setText(userData.getName());
        holder.tvId.setText(String.valueOf(userData.getId()));

    }

    @Override
    public int getItemCount() {
        return userDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvId;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvId = (TextView) itemView.findViewById(R.id.tv_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    final int pos = getAdapterPosition();
                    FragmentManager fm = ((MainActivity) context).getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key",userDatas.get(pos));
                    SingleUserDataFragment singleUserDataFragment = new SingleUserDataFragment();
                    singleUserDataFragment.setArguments(bundle);
                    ft.replace(R.id.fllayout,singleUserDataFragment);
                    ft.commit();
                }
            });
        }
    }
}