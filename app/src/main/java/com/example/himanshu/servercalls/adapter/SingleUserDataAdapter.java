package com.example.himanshu.servercalls.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.servercalls.R;
import com.example.himanshu.servercalls.model.SingleUserData;

import java.util.List;

/**
 * Created by himanshu on 9/5/17.
 */

public class SingleUserDataAdapter extends RecyclerView.Adapter<SingleUserDataAdapter.ViewHolder> {

    private Context context;
    private List<SingleUserData> singleUserDatas;
    private SingleUserData singleUserData;

    public SingleUserDataAdapter(final Context context, final List<SingleUserData> singleUserDatas) {
        this.context = context;
        this.singleUserDatas = singleUserDatas;
    }

    @Override
    public SingleUserDataAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_post_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        /**
         * return view holder
         */
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
    singleUserData = singleUserDatas.get(position);
        holder.tvId.setText(String.valueOf(singleUserData.getId()));
        holder.tvUserId.setText(String.valueOf(singleUserData.getUserId()));
        holder.tvBody.setText(singleUserData.getBody());
        holder.tvTitle.setText(singleUserData.getTitle());
    }

    @Override
    public int getItemCount() {
        return singleUserDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvUserId, tvBody, tvTitle;
        public ViewHolder(final View view) {
            super(view);
            tvId = (TextView) view.findViewById(R.id.tv_id);
            tvUserId = (TextView) view.findViewById(R.id.tv_user_id);
            tvBody = (TextView) view.findViewById(R.id.tv_body);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
