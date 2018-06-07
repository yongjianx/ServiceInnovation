package com.example.skyworthclub.serviceinnovation.Project.utils;

import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Main.activity.MainActivity;
import com.example.skyworthclub.serviceinnovation.Project.model.project;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Awei on 2018/3/22.
 */

public class httpUtils {
    public String projectStatusUrl = "XXXXX";
    public String myProjectUrl = "xxxx";
    public List<project> allProject;

//    //获取所有项目
//    public void getAllProjects(){
////        return ;
//    }
//    public static String getRes(String url){
//        final String[] res = {null};
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder().get().url(url).build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                res[0] = response.body().string();
//            }
//        });
//        return res[0];
//    }

}
