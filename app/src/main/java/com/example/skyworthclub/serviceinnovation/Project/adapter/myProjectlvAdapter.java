package com.example.skyworthclub.serviceinnovation.Project.adapter;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.Project.model.project;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

/**
 * Created by Awei on 2018/3/22.
 */

public class myProjectlvAdapter extends BaseAdapter {
    public List<project> projects =new ArrayList<>();
    public LayoutInflater inflater;
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }

    public myProjectlvAdapter(List<project> projects, LayoutInflater inflater){
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
        final TextView projectName = item.findViewById(R.id.projectName);
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

