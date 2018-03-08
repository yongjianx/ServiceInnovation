package com.example.skyworthclub.serviceinnovation.Main.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.Main.adapter.ViewPagerAdapter;
import com.example.skyworthclub.serviceinnovation.Forum.fragment.Forum;
import com.example.skyworthclub.serviceinnovation.Homepage.fragment.HomePage;
import com.example.skyworthclub.serviceinnovation.Mine.fragment.Mine;
import com.example.skyworthclub.serviceinnovation.Project.fragment.Project;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    //tabLayout的文字数据
    private List<String> tabLists;
    //fragment数据
    private List<android.support.v4.app.Fragment> fragmentLists;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_main);

        init();
        initContent();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.xyj_tab_image).setFocusable(true);
                tab.getCustomView().findViewById(R.id.xyj_tab_text).setFocusable(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.xyj_tab_image).setFocusable(false);
                tab.getCustomView().findViewById(R.id.xyj_tab_text).setFocusable(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void init(){
        tabLayout = findViewById(R.id.xyj_tabLayout);
        viewPager = findViewById(R.id.xyj_viewPager);
    }

    private void initContent(){
        tabLists = new ArrayList<String>();
        tabLists.add("首页");
        tabLists.add("论坛");
        tabLists.add("项目");
        tabLists.add("我的");

        HomePage homePage = new HomePage();
        Forum forum = new Forum();
        Project project = new Project();
        Mine mine = new Mine();

        fragmentLists = new ArrayList<Fragment>();
        fragmentLists.add(homePage);
        fragmentLists.add(forum);
        fragmentLists.add(project);
        fragmentLists.add(mine);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLists,
                fragmentLists);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //加载tabLayout的自定义布局
        for (int i=0; i<tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null){
                tab.setCustomView(viewPagerAdapter.getTabView(this, i));
            }
        }
    }


}
