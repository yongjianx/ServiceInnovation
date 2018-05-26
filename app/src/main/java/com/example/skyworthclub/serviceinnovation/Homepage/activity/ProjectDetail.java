package com.example.skyworthclub.serviceinnovation.Homepage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.adapter.ItemDetailAdapter;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;


public class ProjectDetail extends AppCompatActivity {
    private final static String TAG = "ProjectDetail";

    private Toolbar toolbar;
    private ImageView back;
    private TextView project_name;
    private TextView company_name;
    private TextView project_cycle;
    private TextView project_release;
    private TextView project_money;
    //recyclerView
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private TextView post;

    private List<String> names = new ArrayList<>();
    private List<String> contents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeproject_detail);
        init();
        toolBarInit();

        initRecycleView();
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProjectDetail.this, "投递简历" ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecycleView(){
        names.add("项目描述");
        names.add("人员要求");
        names.add("项目要求");
        contents.add("项目描述 项目描述 项目描述 项目描述 项目描述 项目描述 项目描述 项目描述 项目描述");
        contents.add("人员要求 人员要求 人员要求 人员要求 人员要求 人员要求 人员要求 人员要求 人员要求 人员要求");
        contents.add("项目要求 项目要求 项目要求 项目要求 项目要求 项目要求 项目要求 项目要求 项目要求 项目要求 项目要求");

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ItemDetailAdapter itemDetailAdapter = new ItemDetailAdapter(names, contents, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemDetailAdapter);
    }

    private void init(){
        toolbar = findViewById(R.id.project_detail);
        back = findViewById(R.id.homepage_project_back);

        project_name = findViewById(R.id.detail_project_name);
        company_name = findViewById(R.id.detail_company_name);
        project_cycle = findViewById(R.id.detail_project_cycle);
        project_release = findViewById(R.id.detail_project_release);
        project_release = findViewById(R.id.detail_project_money);

        recyclerView = findViewById(R.id.recycleView);
        post = findViewById(R.id.post);
    }
    private void toolBarInit(){
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
