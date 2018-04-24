package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Mine.activity.MessageDialogActivity;
import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by dn on 2018/4/4.
 */

public class MyMessageAdapter extends RecyclerView.Adapter<MyMessageAdapter.MessageViewHolder>{

    private Context mContext;

    public MyMessageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_message_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder holder, int position) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MessageDialogActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView portraitImg;
        TextView messageSenderTv;
        TextView messageInfoTv;
        TextView messageTimeTv;

        public MessageViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.my_message_layout);
            portraitImg = itemView.findViewById(R.id.portrait_img);
            messageSenderTv = itemView.findViewById(R.id.message_sender_tv);
            messageInfoTv = itemView.findViewById(R.id.message_info_tv);
            messageTimeTv = itemView.findViewById(R.id.message_receive_time_tv);
        }
    }

}
