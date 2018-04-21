package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by dn on 2018/4/5.
 */

public class SubscribeAdapter extends RecyclerView.Adapter<SubscribeAdapter.SubscribeViewHolder> {

    @Override
    public SubscribeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_subscribe_item, parent, false);
        return new SubscribeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubscribeViewHolder holder, int position) {
        holder.showBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class SubscribeViewHolder extends RecyclerView.ViewHolder {
        TextView projectTypeTv;
        TextView subscribeNameTv;
        TextView addressTv;
        TextView wagesTv;
        ImageView unSubscribeImg;
        Switch showBtn;
        public SubscribeViewHolder(View itemView) {
            super(itemView);
            projectTypeTv = itemView.findViewById(R.id.subscribe_project_type_tv);
            subscribeNameTv = itemView.findViewById(R.id.subscribe_name_tv);
            addressTv = itemView.findViewById(R.id.subscribe_address_tv);
            wagesTv = itemView.findViewById(R.id.subscribe_wages_tv);
            unSubscribeImg = itemView.findViewById(R.id.unsubscribe_img);
            showBtn = itemView.findViewById(R.id.subscribe_tgbtn);
        }
    }

}
