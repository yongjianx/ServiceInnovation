package com.example.skyworthclub.serviceinnovation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Loader.GlideImageLoader;
import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.adapter.HpItemAdapter;
import com.example.skyworthclub.serviceinnovation.adapter.ItemAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class HomePage extends Fragment implements AdapterView.OnItemClickListener{
    //轮播图片
    private List<Integer> images = new ArrayList<>();
    private Banner banner;

    //listView
    private ListView listView;
    private ItemAdapter itemAdapter;
    //用来存放item的数据mDatas
    private List<HashMap<String, String>> mDatas;
    private HashMap<String, String> hashMap = new HashMap<>();

    //recyclerView
    private RecyclerView recyclerView;
    private HpItemAdapter hpItemAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<HashMap<String, String>> datas;
    private HashMap<String, String> mHashMap = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        images.add(R.drawable.pic1);
        images.add(R.drawable.pic2);
        images.add(R.drawable.pic3);

        //listView测试
        mDatas = new ArrayList<>();
        //recyclerView测试
        datas = new ArrayList<>();

        for (int i=0; i<6; i++){
            //recyclerView
            mHashMap.clear();
            mHashMap.put("HpItemContent", "android");
            datas.add(mHashMap);

            //listView
            hashMap.clear();
            hashMap.put("projectName", "创维俱乐部");
            hashMap.put("releaseTime", "2018-1-10");
            hashMap.put("companyName", "腾讯");
            hashMap.put("address", "深圳");
            hashMap.put("time", "6个月");
            hashMap.put("money", "5000");
            mDatas.add(hashMap);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xyj_homepage, container, false);
        banner = view.findViewById(R.id.xyj_banner);

        initHorizontalView();
        recyclerView = view.findViewById(R.id.xyj_recyclerView);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(hpItemAdapter);

        //listView的配置
        listView = view.findViewById(R.id.xyj_listView);
        itemAdapter = new ItemAdapter(getContext(), mDatas);
        itemAdapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "你点击了listView" + position, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(itemAdapter);
        initBanner();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG", "onItemClick: " + position);
        Toast.makeText(getContext(), "你点击的是listView "+ position, Toast.LENGTH_SHORT).show();
    }

    /*
        轮播图初始化
         */
    private void initBanner(){
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    /*
    横向listItem初始化
     */
    private void initHorizontalView(){
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        hpItemAdapter = new HpItemAdapter(datas);

        hpItemAdapter.setOnItemClickListener(new HpItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
