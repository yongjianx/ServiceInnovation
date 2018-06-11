package com.example.skyworthclub.serviceinnovation.Mine.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dn on 2018/6/10.
 */

public class ToastUtil {
    public static void show(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
