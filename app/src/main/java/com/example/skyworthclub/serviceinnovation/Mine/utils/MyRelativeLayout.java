package com.example.skyworthclub.serviceinnovation.Mine.utils;

import android.widget.RelativeLayout;

/**
 * Created by 26792 on 2018/3/14.
 */

public class MyRelativeLayout  {
    private String mcolor;
    private String mtitle_tv;
    private String mbottom_tv;
    public MyRelativeLayout(String color, String title_tv,String bottom_tv){
        mcolor=color;
        mbottom_tv=bottom_tv;
        mtitle_tv=title_tv;
    }
       public String getMcolor(){
        return mcolor;
       }
       public String getMtitle_tv(){
           return mtitle_tv;
       }
       public String getMbottom_tv(){
           return mbottom_tv;
       }
}
