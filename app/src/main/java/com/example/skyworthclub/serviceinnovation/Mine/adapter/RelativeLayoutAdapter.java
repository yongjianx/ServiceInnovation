package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Mine.utils.MyRelativeLayout;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.List;

/**
 * Created by 26792 on 2018/3/14.
 */

public class RelativeLayoutAdapter extends RecyclerView.Adapter<RelativeLayoutAdapter.ViewHolder>{
    private List<MyRelativeLayout> mrelativeLayouts;
    public RelativeLayoutAdapter(List<MyRelativeLayout>relativeLayouts){
        mrelativeLayouts=relativeLayouts;
    }
    @Override
    public RelativeLayoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
       ViewHolder holder=new ViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(RelativeLayoutAdapter.ViewHolder holder, int position) {
        MyRelativeLayout relativeLayout=mrelativeLayouts.get(position);
//        GradientDrawable gradientDrawable= (GradientDrawable) holder.mview.getBackground();
//        gradientDrawable.setColor(Color.parseColor("#4FC3F7"));
        holder.mview.setBackgroundColor(Color.parseColor(relativeLayout.getMcolor()));
        holder.mtextView.setText(relativeLayout.getMtitle_tv());
        holder.mbottom_tv.setText(relativeLayout.getMbottom_tv());

    }

    @Override
    public int getItemCount() {
        return mrelativeLayouts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View mview;
        TextView mtextView;
        EditText meditText;
        TextView mbottom_tv;
        public ViewHolder(View itemView) {
            super(itemView);
           mview=itemView.findViewById(R.id.mine_resume_spot);
           mtextView=itemView.findViewById(R.id.mine_resume_textview);
            meditText=itemView.findViewById(R.id.mine_resume_et);
            mbottom_tv=itemView.findViewById(R.id.mine_resume_tv);
        }
    }
}
