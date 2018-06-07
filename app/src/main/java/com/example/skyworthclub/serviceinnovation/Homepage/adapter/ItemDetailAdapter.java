package com.example.skyworthclub.serviceinnovation.Homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

import java.util.List;

/**
 * Created by skyworthclub on 2018/5/13.
 */

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.ViewHolder> {
    private List<String> names;
    private List<String> contents;
    //屏幕密度
    private final float scale;

    public ItemDetailAdapter(List<String> names, List<String> contents, Context context){
        this.names = names;
        this.contents = contents;
        scale = context.getResources().getDisplayMetrics().density;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_homepageproject_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return names == null? 0: names.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ViewGroup.LayoutParams params = holder.content.getLayoutParams();
        switch (position){
            case 0:
                params.height = (int) (95*scale+0.5f);
                break;
            case 1:
                params.height = (int) (75*scale+0.5f);
            case 2:
                params.height = (int) (75*scale+0.5f);
                default:
                    break;
        }
        holder.content.setLayoutParams(params);

        holder.name.setText(names.get(position));
        holder.content.setText(contents.get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        private TextView content;

        public ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            content = view.findViewById(R.id.content);
        }
    }
}
