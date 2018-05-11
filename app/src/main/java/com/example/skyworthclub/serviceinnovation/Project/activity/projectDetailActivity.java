package com.example.skyworthclub.serviceinnovation.Project.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.skyworthclub.serviceinnovation.Project.adapter.ProjectDetailvAdapter;
import com.example.skyworthclub.serviceinnovation.R;

public class projectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lvDetail = findViewById(R.id.lv_detail);
        LayoutInflater inflater = LayoutInflater.from(this);

        ProjectDetailvAdapter projectDetailvAdapter = new ProjectDetailvAdapter(3,inflater);
        lvDetail.setAdapter(projectDetailvAdapter);
//        LinearLayout llDetail = findViewById(R.id.ll_detail);
//        View llCard = LayoutInflater.from(this).inflate(R.layout.content_project_content,null);
//        View llCard2 = LayoutInflater.from(this).inflate(R.layout.content_project_content,null);
//        llDetail.addView(llCard);
//        llDetail.addView(llCard2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
