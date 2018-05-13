package com.example.skyworthclub.serviceinnovation.Homepage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;


public class ProjectDetail extends AppCompatActivity {
    private final static String TAG = "ProjectDetail";

    private Toolbar toolbar;
    private ImageView back;
    private TextView project_name;
    private TextView company_name;
    private TextView project_cycle;
    private TextView project_release;
    private TextView project_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeproject_detail);
        init();
        toolBarInit();
    }

    private void init(){
        toolbar = findViewById(R.id.project_detail);
        back = findViewById(R.id.homepage_project_back);

        project_name = findViewById(R.id.detail_project_name);
        company_name = findViewById(R.id.detail_company_name);
        project_cycle = findViewById(R.id.detail_project_cycle);
        project_release = findViewById(R.id.detail_project_release);
        project_release = findViewById(R.id.detail_project_money);
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
