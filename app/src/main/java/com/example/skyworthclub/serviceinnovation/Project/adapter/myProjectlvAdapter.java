package com.example.skyworthclub.serviceinnovation.Project.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Project.model.project;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awei on 2018/3/22.
 */

public class myProjectlvAdapter extends BaseAdapter {
    public List<project> projects =new ArrayList<>();
    public LayoutInflater inflater;
    public myProjectlvAdapter(List<project> projects,LayoutInflater inflater){
        this.inflater = inflater;
        this.projects = projects;
    }
    @Override
    public int getCount() {
        return projects.size();
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
        View item = inflater.inflate(R.layout.project_lv_item, null);
        project pj = projects.get(i);
        boolean ifFinish = pj.getProjectStatus();
        TextView projectName = item.findViewById(R.id.projectName);
        TextView projectStatus = item.findViewById(R.id.projectStatus);
        projectName.setText(pj.getProjectName());
        if(ifFinish){
            projectStatus.setText("已完成");
        }else{
            projectStatus.setText("进行中");
            projectStatus.setTextColor(Color.rgb(63,136,52));
        }
        return item;
    }
}

