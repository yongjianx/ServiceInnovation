package com.example.skyworthclub.serviceinnovation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> tabLists;
    private List<Fragment> fragmentLists;

    public ViewPagerAdapter(FragmentManager fm, List<String> tabLists, List<Fragment> fragmentLists){
        super(fm);
        this.tabLists = tabLists;
        this.fragmentLists = fragmentLists;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return tabLists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLists.get(position);
    }
}
