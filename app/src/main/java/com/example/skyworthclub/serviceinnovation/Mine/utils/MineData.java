package com.example.skyworthclub.serviceinnovation.Mine.utils;

/**
 * Created by 26792 on 2018/3/17.
 */

public class MineData {
    private String mcolor;
    private String medittext;
    private String name;
    public MineData(String name,String color,String edittext){
        this.name=name;
        mcolor=color;
        medittext=edittext;
    }
    public MineData(String name,String color){
        this.name=name;
        mcolor=color;
    }
    public String getName(){
        return name;
    }
    public String getMcolor(){
        return mcolor;
    }
    public  String getMedittext(){
        return medittext;
    }
}
