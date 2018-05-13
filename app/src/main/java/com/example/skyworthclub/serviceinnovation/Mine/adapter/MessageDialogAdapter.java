package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by dn on 2018/4/4.
 */

public class MessageDialogAdapter extends RecyclerView.Adapter<MessageDialogAdapter.MessageDialogViewHolder> {

    @Override
    public MessageDialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_dialog_item, parent, false);
        return new MessageDialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageDialogViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MessageDialogViewHolder extends RecyclerView.ViewHolder {
        public MessageDialogViewHolder(View itemView) {
            super(itemView);
        }
    }

}
