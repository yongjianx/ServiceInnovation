package com.example.skyworthclub.serviceinnovation.Project.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Project.activity.projectDetailActivity;
import com.example.skyworthclub.serviceinnovation.Project.adapter.myProjectlvAdapter;
import com.example.skyworthclub.serviceinnovation.Project.model.project;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Project extends Fragment {
    //判断是否处于登陆状态
    public List<project> projects = new ArrayList<>();
    public project pjTest1,pjTest2;
    public boolean ifLogin=false;
    public ListView projectsLv;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        pjTest1 = new project();
        pjTest2 = new project();
        pjTest1.setProjectName("创维俱乐部web开发");
        pjTest1.setProjectStatus(true);
        pjTest2.setProjectName("创维俱乐部APP开发");
        pjTest2.setProjectStatus(false);
        projects.add(pjTest1);
        projects.add(pjTest2);
        if(!ifLogin){
            View view = inflater.inflate(R.layout.project_main, container, false);
            projectsLv = view.findViewById(R.id.project_lv);
            myProjectlvAdapter adapter =new myProjectlvAdapter(projects,inflater);
            projectsLv.setAdapter(adapter);
            projectsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(),"已点击",Toast.LENGTH_SHORT).show();
                    Intent pjDetail = new Intent(getActivity(),projectDetailActivity.class);
                    startActivity(pjDetail);
                }
            });
            return view;
        }else{
            //创建alertdialog实例
            AlertDialog loginDiaglog = new AlertDialog.Builder(getActivity())
                    .setMessage("您还未登陆，无法查看项目详情！")
                    .setPositiveButton("前往登陆",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //如果用户选择登陆 进行跳转,暂时不写
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //选择取消，不进行操作
                        }
                    }).create();
            //显示对话框
            loginDiaglog.show();
            View view = inflater.inflate(R.layout.project_blank,container,false);
            return view;
        }

    }
}
