package com.example.skyworthclub.serviceinnovation.Homepage.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.activity.HomepageSearch;
import com.example.skyworthclub.serviceinnovation.Homepage.activity.ProjectDetail;
import com.example.skyworthclub.serviceinnovation.Homepage.adapter.HorizontalItemAdapter;
import com.example.skyworthclub.serviceinnovation.Homepage.utils.GlideImageLoader;
import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.Homepage.adapter.VerticalAdapter2;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class HomePage extends Fragment {
    private final static String TAG = "HomePage";
    //轮播图片，耗时任务，异步任务
    private List<Integer> bannerImages = new ArrayList<>();
    private Banner banner;

    //竖向listView
    private RecyclerView verticalItemView;
    //存放竖向listView数据,耗时任务
    private Bitmap bitmap;
    private List<Bitmap> projectBitmap = new ArrayList<>();
    private HashMap<String, String> projectHashMap = new HashMap<>();
    private List<HashMap<String, String>> projectDatas = new ArrayList<>();

    //horizontalItemView
    private RecyclerView horizontalItemView;
    private List<String> datas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //加载轮播图片
        bannerImages.add(R.drawable.homepage_employ);
        bannerImages.add(R.drawable.homepage_pic2);
        bannerImages.add(R.drawable.homepage_pic3);

        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.homepage_android);

        //horizontalItemView
        datas.add("互联网");
        datas.add("电子电气");
        datas.add("媒体设计");
        datas.add("机械制造");
        datas.add("教育咨询");
        datas.add("外语外贸");

        for (int i=0; i<9; i++){
            //listView
            projectHashMap.clear();
            projectHashMap.put("projectName", "创维俱乐部");
            projectHashMap.put("releaseTime", "2018-1-10");
            projectHashMap.put("companyName", "腾讯");
            projectHashMap.put("address", "深圳");
            projectHashMap.put("time", "6个月");
            projectHashMap.put("money", "5000");
            projectDatas.add(projectHashMap);
            projectBitmap.add(bitmap);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_main, container, false);
        banner = view.findViewById(R.id.xyj_banner);
        horizontalItemView = view.findViewById(R.id.xyj_recyclerView);
        verticalItemView = view.findViewById(R.id.xyj_listView);
        ImageView homepageSearch = view.findViewById(R.id.homepage_search);

        //search搜索的点击事件
        homepageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomepageSearch.class);
                startActivity(intent);
            }
        });

        initHorizontalView();
        initVerticalView();

        initBanner();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        banner.stopAutoPlay();
    }

    //    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Log.e("TAG", "onItemClick: " + position);
//        Toast.makeText(getContext(), "你点击的是listView "+ position, Toast.LENGTH_SHORT).show();
//    }

    /*
     轮播图初始化
    */
    private void initBanner(){
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerImages);
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        HorizontalItemAdapter horizontalItemAdapter;
        horizontalItemAdapter = new HorizontalItemAdapter(datas);

        horizontalItemAdapter.setOnItemClickListener(new HorizontalItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }
        });

        // 设置布局管理器
        horizontalItemView.setLayoutManager(layoutManager);
        horizontalItemView.setAdapter(horizontalItemAdapter);
    }

    /*
    竖向listItem初始化
     */
    private void initVerticalView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);

        VerticalAdapter2 VerticalAdapter2;
        //listView的配置
        VerticalAdapter2 = new VerticalAdapter2(projectDatas, projectBitmap);
        VerticalAdapter2.setOnItemClickListener(new VerticalAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ProjectDetail.class);
                startActivity(intent);
            }
        });
        verticalItemView.setLayoutManager(layoutManager);
        verticalItemView.setAdapter(VerticalAdapter2);
    }
}
