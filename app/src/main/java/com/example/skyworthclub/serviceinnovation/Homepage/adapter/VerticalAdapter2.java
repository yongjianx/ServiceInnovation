package com.example.skyworthclub.serviceinnovation.Homepage.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by skyworthclub on 2018/6/5.
 */

public class VerticalAdapter2 extends RecyclerView.Adapter<VerticalAdapter2.ViewHolder> {
    private VerticalAdapter2.OnItemClickListener onItemClickListener;

    private List<HashMap<String, String>> mDatas = new ArrayList<HashMap<String, String>>();
    private List<Bitmap> bitmaps = new ArrayList<>();

    public VerticalAdapter2(List<HashMap<String, String>> datas, List<Bitmap> bitmaps){

        this.mDatas = datas;
        this.bitmaps = bitmaps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_vertical_item,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        viewHolder.mImageView.setImageBitmap(bitmaps.get(position));
        viewHolder.mProjectName.setText(mDatas.get(position).get("projectName"));
        viewHolder.mReleaseTime.setText(mDatas.get(position).get("releaseTime"));
        viewHolder.mCompanyName.setText(mDatas.get(position).get("companyName"));
        viewHolder.mAddress.setText(mDatas.get(position).get("address"));
        viewHolder.mTime.setText(mDatas.get(position).get("time"));
        viewHolder.mMoney.setText(mDatas.get(position).get("money"));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    int pos = viewHolder.getLayoutPosition();
                    //回调方法
                    onItemClickListener.onItemClick(viewHolder.itemView, pos);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null? 0: mDatas.size();
    }

    public void setOnItemClickListener(VerticalAdapter2.OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mProjectName;
        private TextView mReleaseTime;
        private TextView mCompanyName;
        private TextView mAddress;
        private TextView mTime;
        private TextView mMoney;

        public ViewHolder(View view){
            super(view);

            mImageView = view.findViewById(R.id.xyj_pic);
            mProjectName = view.findViewById(R.id.xyj_projectName);
            mReleaseTime = view.findViewById(R.id.xyj_releaseTime);
            mCompanyName = view.findViewById(R.id.xyj_companyName);
            mAddress = view.findViewById(R.id.xyj_address);
            mTime = view.findViewById(R.id.xyj_cycleTime);
            mMoney = view.findViewById(R.id.xyj_money);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
