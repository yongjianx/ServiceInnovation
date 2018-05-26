package com.example.skyworthclub.serviceinnovation.Mine.utils;

import android.os.Looper;

/**
 * Created by 26792 on 2018/5/17.
 */

public class TestClass {
    public TestClass() {
    }

    public boolean isMainThread(){
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
