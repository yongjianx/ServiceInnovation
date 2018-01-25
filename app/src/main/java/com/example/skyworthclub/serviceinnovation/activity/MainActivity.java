package com.example.skyworthclub.serviceinnovation.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.example.skyworthclub.serviceinnovation.R;
import com.example.skyworthclub.serviceinnovation.adapter.ViewPagerAdapter;
import com.example.skyworthclub.serviceinnovation.fragment.Forum;
import com.example.skyworthclub.serviceinnovation.fragment.HomePage;
import com.example.skyworthclub.serviceinnovation.fragment.Mine;
import com.example.skyworthclub.serviceinnovation.fragment.Project;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> tabLists;
    private List<android.support.v4.app.Fragment> fragmentLists;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xyj_main);

        init();
        initContent();
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
    }


}
