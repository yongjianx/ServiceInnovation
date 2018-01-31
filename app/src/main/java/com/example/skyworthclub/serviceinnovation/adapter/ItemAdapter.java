package com.example.skyworthclub.serviceinnovation.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/22.
 */

public class ItemAdapter extends BaseAdapter {
    private ItemAdapter.OnItemClickListener onItemClickListener;

    private List<HashMap<String, String>> mDatas;
    private LayoutInflater layoutInflater;
    private Bitmap bitmap;

    public ItemAdapter(Context context, List<HashMap<String, String>> datas){
        layoutInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<HashMap<String, String>>();
        mDatas = datas;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.xyj_hp_listitem, null);
            viewHolder.mImageView = convertView.findViewById(R.id.xyj_pic);
            viewHolder.mProjectName = convertView.findViewById(R.id.xyj_projectName);
            viewHolder.mReleaseTime = convertView.findViewById(R.id.xyj_releaseTime);
            viewHolder.mCompanyName = convertView.findViewById(R.id.xyj_companyName);
            viewHolder.mAddress = convertView.findViewById(R.id.xyj_address);
            viewHolder.mTime = convertView.findViewById(R.id.xyj_cycleTime);
            viewHolder.mMoney = convertView.findViewById(R.id.xyj_money);

            convertView.setTag(viewHolder);
         }
         else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mImageView.setImageBitmap(bitmap);
        viewHolder.mProjectName.setText(mDatas.get(position).get("projectName"));
        viewHolder.mReleaseTime.setText(mDatas.get(position).get("releaseTime"));
        viewHolder.mCompanyName.setText(mDatas.get(position).get("companyName"));
        viewHolder.mAddress.setText(mDatas.get(position).get("address"));
        viewHolder.mTime.setText(mDatas.get(position).get("time"));
        viewHolder.mMoney.setText(mDatas.get(position).get("money"));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });

         return convertView;
    }

    public void setOnItemClickListener(ItemAdapter.OnItemClickListener listener){
        onItemClickListener = listener;
    }

    private static class ViewHolder{
        private ImageView mImageView;
        private TextView mProjectName;
        private TextView mReleaseTime;
        private TextView mCompanyName;
        private TextView mAddress;
        private TextView mTime;
        private TextView mMoney;

    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

}
