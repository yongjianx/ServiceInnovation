package com.example.skyworthclub.serviceinnovation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

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

    public View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.xyj_tablayout, null);
        ImageView imageView = view.findViewById(R.id.xyj_tab_image);
        TextView textView = view.findViewById(R.id.xyj_tab_text);
        textView.setText(tabLists.get(position));
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.xyj_home_state);
                break;
            case 1:
                imageView.setImageResource(R.drawable.xyj_forum_state);
                break;
            case 2:
                imageView.setImageResource(R.drawable.xyj_project_state);
                break;
            case 3:
                imageView.setImageResource(R.drawable.xyj_mine_state);
                break;
            default:
                    break;
        }
        return view;
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
