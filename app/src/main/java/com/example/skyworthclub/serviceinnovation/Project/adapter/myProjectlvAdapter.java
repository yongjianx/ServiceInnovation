package com.example.skyworthclub.serviceinnovation.Project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.example.skyworthclub.serviceinnovation.Project.model.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awei on 2018/3/22.
 */

public class myProjectlvAdapter extends BaseAdapter {
    public List<project> projects =new ArrayList<>();
    public LayoutInflater inflater;
    public myProjectlvAdapter(List<project> projects){
        this.projects = projects;
    }
    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Object getItem(int i) {
        return projects.indexOf(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        View view = inflater.inflate(R)
        return null;
    }
}

