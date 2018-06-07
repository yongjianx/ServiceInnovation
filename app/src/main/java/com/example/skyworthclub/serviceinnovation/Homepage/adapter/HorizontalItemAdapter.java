package com.example.skyworthclub.serviceinnovation.Homepage.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/25.
 * 横向的listView
 */

public class HorizontalItemAdapter extends RecyclerView.Adapter<HorizontalItemAdapter.ViewHolder> {
    //事件回调监听
    private HorizontalItemAdapter.OnItemClickListener onItemClickListener;

    //文字信息
//    private List<HashMap<String, String>> mDatas;
    private List<String> mDatas;
    //图标信息
    private Bitmap bitmap;
    private List<Bitmap> bitmaps = new ArrayList<>();

    public HorizontalItemAdapter(List<String> mDatas){
        this.mDatas = mDatas;
    }

    public void updataData(List<String> datas){
        mDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //实例化需要展示的view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_horizontal_item, parent, false);

        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_internet);
        bitmaps.add(bitmap);
        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_electron);
        bitmaps.add(bitmap);
        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_media);
        bitmaps.add(bitmap);
        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_machine);
        bitmaps.add(bitmap);
        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_educate);
        bitmaps.add(bitmap);
        bitmap = BitmapFactory.decodeResource(parent.getResources(), R.drawable.homepage_language);
        bitmaps.add(bitmap);

        //实例化viewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mDatas == null? 0:mDatas.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        //绑定数据
        viewHolder.imageView.setImageBitmap(bitmaps.get(position));
        viewHolder.textView.setText(mDatas.get(position));

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

    /*
    设置回调监听
     */
    public void setOnItemClickListener(HorizontalItemAdapter.OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.xyj_item_image);
            textView = view.findViewById(R.id.xyj_item_textView);
        }
    }


    //接口实现回调
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
