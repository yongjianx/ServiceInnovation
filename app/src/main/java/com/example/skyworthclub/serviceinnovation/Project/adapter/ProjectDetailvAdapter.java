package com.example.skyworthclub.serviceinnovation.Project.adapter;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.CornerPathEffect;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Project.activity.projectDetailActivity;
import com.example.skyworthclub.serviceinnovation.Project.model.project;
import com.example.skyworthclub.serviceinnovation.Project.utils.myDialog;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awei on 2018/3/22.
 */

public class ProjectDetailvAdapter extends BaseAdapter {
    public int stageNum;
    public LayoutInflater inflater;
    public project projectI = new project();
    public projectDetailActivity context;
    public ProjectDetailvAdapter(int stageNum, LayoutInflater inflater, project projectI,projectDetailActivity context){
        this.projectI = projectI;
        this.inflater = inflater;
        this.stageNum = stageNum;
        this.context = context;
    }
    @Override
    public int getCount() {
        return stageNum;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item =inflater.inflate(R.layout.content_project_content, null);
        TextView stage = item.findViewById(R.id.stage);
        stage.setText("阶段"+(i+1));
        ProgressBar progressBar = item.findViewById(R.id.progress);
        progressBar.setProgress(100);
        progressBar.getProgressDrawable().setColorFilter(Color.rgb(63, 136, 252), PorterDuff.Mode.SRC_IN);

        final int a = i;
        final TextView des = item.findViewById(R.id.index);
        final TextView des2 = item.findViewById(R.id.index2);
        final TextView des3 = item.findViewById(R.id.index3);
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog dialog = new myDialog(context);
                dialog.show();
            }
        });
        des2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog dialog = new myDialog(context);
                dialog.show();
            }
        });
        des3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog dialog = new myDialog(context);
                dialog.show();
            }
        });

        //        project pj = projects.get(i);
//        boolean ifFinish = pj.getProjectStatus();
//        TextView projectName = item.findViewById(R.id.projectName);
//        TextView projectStatus = item.findViewById(R.id.projectStatus);
//        projectName.setText(pj.getProjectName());
//        if(ifFinish){
//            projectStatus.setText("已完成");
//        }else{
//            projectStatus.setText("进行中");
//            projectStatus.setTextColor(Color.rgb(63,136,52));
//        }
        return item;
    }
}

