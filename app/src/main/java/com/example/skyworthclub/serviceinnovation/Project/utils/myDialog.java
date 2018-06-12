package com.example.skyworthclub.serviceinnovation.Project.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.example.skyworthclub.serviceinnovation.R;


/**
 * Created by Awei on 2018/6/7.
 */

public class myDialog extends Dialog {
    public Context context;
    public myDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public myDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

    }

    protected myDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.decdialog, null);
        setContentView(view);
    }
}
