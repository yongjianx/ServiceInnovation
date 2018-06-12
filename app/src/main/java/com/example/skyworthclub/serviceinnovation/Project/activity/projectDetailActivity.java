package com.example.skyworthclub.serviceinnovation.Project.activity;

import com.example.skyworthclub.serviceinnovation.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.skyworthclub.serviceinnovation.Project.adapter.ProjectDetailvAdapter;
import com.example.skyworthclub.serviceinnovation.Project.model.project;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class projectDetailActivity extends AppCompatActivity {
    public int proId = 0;
    public project projectI = new project();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        //取出本项目ID
        Intent intent = getIntent();
        proId = intent.getIntExtra("proId",0);
        // getResponse(url);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lvDetail = findViewById(R.id.lv_detail);
        LayoutInflater inflater = LayoutInflater.from(this);

        ProjectDetailvAdapter projectDetailvAdapter = new ProjectDetailvAdapter(3,inflater,projectI,this);

        lvDetail.setAdapter(projectDetailvAdapter);

//        LinearLayout llDetail = findViewById(R.id.ll_detail);
//        View llCard = LayoutInflater.from(this).inflate(R.layout.content_project_content,null);
//        View llCard2 = LayoutInflater.from(this).inflate(R.layout.content_project_content,null);
//        llDetail.addView(llCard);
//        llDetail.addView(llCard2);
    }


    //从后台拿到数据
    public void getResponse(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //解析json数据
                try{
                    JSONArray jsonArray = new JSONArray(jsonData);
                    for(int i= 0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        projectI.setProjectName(jsonObject.getString("proName"));
                        projectI.setProCycle(jsonObject.getInt("proCycle"));
                        projectI.setProDescription(jsonObject.getString("proDescription"));
                        projectI.setProMony(jsonObject.getInt("proMoney"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
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
