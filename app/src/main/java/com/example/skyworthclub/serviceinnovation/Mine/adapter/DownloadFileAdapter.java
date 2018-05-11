package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by dn on 2018/4/11.
 */

public class DownloadFileAdapter extends RecyclerView.Adapter<DownloadFileAdapter.DownloadFileViewHolder> {

    @Override
    public DownloadFileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_file_item, parent, false);
        return new DownloadFileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DownloadFileViewHolder holder, int position) {
        holder.downloadFileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.deleteFileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class DownloadFileViewHolder extends RecyclerView.ViewHolder {
        TextView fileNameTv;
        TextView downloadFileTv;
        TextView deleteFileTv;

        public DownloadFileViewHolder(View itemView) {
            super(itemView);
            fileNameTv = itemView.findViewById(R.id.file_name_tv);
            downloadFileTv = itemView.findViewById(R.id.download_file_tv);
            deleteFileTv = itemView.findViewById(R.id.delete_file_tv);
        }
    }

}
