package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.adapter.RelativeLayoutAdapter;
import com.example.skyworthclub.serviceinnovation.Mine.utils.MyRelativeLayout;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26792 on 2018/3/12.
 */

public class Mine_resume extends AppCompatActivity {
    private List<MyRelativeLayout> relativeLayouts=new ArrayList<>();
    private ImageView imageView;
    private TextView textView;
    private int edit_status=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.mine_resume);
       imageView=findViewById(R.id.mine_resume_title_back);
       textView=findViewById(R.id.mine_resume_title_edit);
       initView();
       initTitleView();
        RecyclerView recyclerView=findViewById(R.id.resume_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RelativeLayoutAdapter adapter=new RelativeLayoutAdapter(relativeLayouts,edit_status);
        recyclerView.setAdapter(adapter);
    }
    private void initTitleView() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mine_resume.this, "click back", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dialog=new AlertDialog.Builder(v.getContext());
                dialog.setMessage("直接退出所有修改将不做保存，是否确定退出修改");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //写退出操作
                        onBackPressed();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //回到编辑界面
                    }
                });
                dialog.show();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_status==0){
                edit_status=1;
                textView.setText("保存");
                    Toast.makeText(Mine_resume.this, "baocun", Toast.LENGTH_SHORT).show();

                    //设置editview为可编辑状态
                    }
                else {
                    edit_status=0;
                    textView.setText("编辑");
                    Toast.makeText(Mine_resume.this, "bianji", Toast.LENGTH_SHORT).show();
                    //设置为不可编辑状态,同时保存数据
                    }
            }
        });
    }

    private void initView() {
        MyRelativeLayout relativeLayout1=new MyRelativeLayout("#4FC3F7","教育背景","0/100");
        MyRelativeLayout relativeLayout2=new MyRelativeLayout("#FFEE58","相关项目经验","0/200");
        MyRelativeLayout relativeLayout3=new MyRelativeLayout("#FF6C72","自我评价","0/100");
        //        relativeLayout1= (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.mine_resume_background, null);
//        relativeLayout2= (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.mine_resume_project, null);
//        relativeLayout3= (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.mine_resume_evaluation, null);
        relativeLayouts.add(relativeLayout1);
        relativeLayouts.add(relativeLayout2);
        relativeLayouts.add(relativeLayout3);
    }
}
