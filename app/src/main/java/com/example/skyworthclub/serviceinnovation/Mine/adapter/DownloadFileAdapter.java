package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.utils.Constant;
import com.example.skyworthclub.serviceinnovation.Mine.utils.DownloadUtil;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dn on 2018/4/11.
 */

public class DownloadFileAdapter extends RecyclerView.Adapter<DownloadFileAdapter.DownloadFileViewHolder> {

    private Context mContext;
    private List<String> mFileList;

    public DownloadFileAdapter(Context context, List<String> fileList) {
        mContext = context;
        mFileList = fileList;
    }

    @Override
    public DownloadFileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_file_item, parent, false);
        return new DownloadFileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DownloadFileViewHolder holder, final int position) {
        holder.downloadFileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = mFileList.get(position);
                String url = Constant.DOWNLOAD_FILE_URL + fileName;
                String savePath = "";
                DownloadUtil.get().download(url, savePath, new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess() {
                        holder.downloadFileTv.setText("已下载");
                    }

                    @Override
                    public void onDownloading(int progress) {
                        holder.downloadFileTv.setText("正在下载" + progress + "%");
                    }

                    @Override
                    public void onDownloadFailed() {
                        holder.downloadFileTv.setText("下载");
                        ((Activity)mContext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mContext, "下载失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
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
        return mFileList.size();
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
