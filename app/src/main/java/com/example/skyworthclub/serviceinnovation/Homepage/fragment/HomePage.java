package com.example.skyworthclub.serviceinnovation.Homepage.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.adapter.HorizontalItemAdapter;
import com.example.skyworthclub.serviceinnovation.Homepage.utils.GlideImageLoader;
import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.Homepage.adapter.HorizontalItemAdapter;
import com.example.skyworthclub.serviceinnovation.Homepage.adapter.VerticalItemAdapter;
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
    //轮播图片，耗时任务，异步任务
    private List<Integer> bannerImages = new ArrayList<>();
    private Banner banner;

    //竖向listView
    private ListView projectListView;
    private VerticalItemAdapter VerticalItemAdapter;
    //存放listView数据,耗时任务
    private Bitmap bitmap;
    private List<Bitmap> projectBitmap = new ArrayList<>();
    private HashMap<String, String> projectHashMap = new HashMap<>();
    private List<HashMap<String, String>> projectDatas = new ArrayList<>();

    //recyclerView
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    //横向listView
    private HorizontalItemAdapter HorizontalItemAdapter;
    private List<HashMap<String, String>> datas = new ArrayList<>();
    private HashMap<String, String> mHashMap = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //加载轮播图片
        bannerImages.add(R.drawable.homepage_employ);
        bannerImages.add(R.drawable.homepage_pic2);
        bannerImages.add(R.drawable.homepage_pic3);

        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.homepage_android);

        for (int i=0; i<6; i++){
            //recyclerView
            mHashMap.clear();
            mHashMap.put("HpItemContent", "android");
            datas.add(mHashMap);

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

        initHorizontalView();
        recyclerView = view.findViewById(R.id.xyj_recyclerView);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(HorizontalItemAdapter);

        //listView的配置
        projectListView = view.findViewById(R.id.xyj_listView);
        VerticalItemAdapter = new VerticalItemAdapter(getContext(), projectDatas, projectBitmap);
        VerticalItemAdapter.setOnItemClickListener(new VerticalItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "你点击了projectListView" + position, Toast.LENGTH_SHORT).show();
            }
        });
        projectListView.setAdapter(VerticalItemAdapter);
        initBanner();

        return view;
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
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        HorizontalItemAdapter = new HorizontalItemAdapter(datas);

        HorizontalItemAdapter.setOnItemClickListener(new HorizontalItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
