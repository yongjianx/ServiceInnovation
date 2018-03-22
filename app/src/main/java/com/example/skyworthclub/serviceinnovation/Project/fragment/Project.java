package com.example.skyworthclub.serviceinnovation.Project.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Project extends Fragment {
    //判断是否处于登陆状态
    public boolean ifLogin=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(!ifLogin){
            View view = inflater.inflate(R.layout.project_main, container, false);
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
