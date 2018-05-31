package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.utils.SharedPreferencesUtil;
import com.example.skyworthclub.serviceinnovation.Mine.adapter.RelativeLayoutAdapter;
import com.example.skyworthclub.serviceinnovation.Mine.utils.MyRelativeLayout;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26792 on 2018/3/12.
 */

public class Mine_resume extends AppCompatActivity {
    private List<MyRelativeLayout> relativeLayouts = new ArrayList<>();
    private ImageView imageView;
    private TextView textView;
    private int edit_status = 1;
    private LinearLayoutManager linearLayoutManager;
    SharedPreferencesUtil sharedPreferencesUtil;
    RelativeLayoutAdapter adapter;
    RecyclerView recyclerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_resume);
        imageView = findViewById(R.id.mine_resume_title_back);
        textView = findViewById(R.id.mine_resume_title_edit);
        sharedPreferencesUtil = new SharedPreferencesUtil(getBaseContext());
        initView();
        initTitleView();
        RecyclerView recyclerView = findViewById(R.id.resume_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RelativeLayoutAdapter(relativeLayouts, edit_status, recyclerView);
        recyclerView.setAdapter(adapter);
    }

    private void initTitleView() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mine_resume.this, "click back", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setMessage("直接退出所有修改将不做保存，是否确定退出修改");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //写退出操作
                        onBackPressed();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //回到编辑界面
                    }
                });
                dialog.show();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_status == 0) {
//                    可编辑状态
                    try {
                        edit_status = 1;
                        textView.setText("保存");
                        saveData(linearLayoutManager);
                    } catch (Exception e) {
                        Log.e("test", "not savedata");
                        Log.e("test2", "edit_status: " + edit_status);
                        e.printStackTrace();
                    }
                    Log.e("test2", "edit_status: " + edit_status);
                    Toast.makeText(Mine_resume.this, "baocun", Toast.LENGTH_SHORT).show();
                    //设置editview为可编辑状态
                } else {
                    try {
                        edit_status = 0;
                        saveData(linearLayoutManager);
                        Log.e("test2", "edit_status: " + edit_status);
                        Toast.makeText(Mine_resume.this, "bianji", Toast.LENGTH_SHORT).show();
                        textView.setText("编辑");
                    } catch (Exception e) {
                        Log.e("test", "not savedata");
                        e.printStackTrace();
                    }
//设置为不可编辑状态,同时保存数据
                }
            }
        });
    }

    //保存数据&判断是否需要隐藏键盘
    private void saveData(LinearLayoutManager linearLayoutManager) {
        for (int position = 0; position <= 2; position++) {
            //            获取recyclerview里面的itemview
            View view = linearLayoutManager.findViewByPosition(position);
//            获取itemview里面edittext的实例
            RelativeLayout layout = (RelativeLayout) view;
            EditText editText = layout.findViewById(R.id.mine_resume_et);
            Log.e("test", "edit_status : " + edit_status);
            if (edit_status == 0) {
                String value = editText.getText().toString();
                sharedPreferencesUtil.putString(relativeLayouts.get(position).getName(), value);
                Log.e("test", "saveData: close input" + relativeLayouts.get(position).getName() + value);
                editText.setInputType(InputType.TYPE_NULL);
                Toast.makeText(this, "saveData", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("test", "saveData:open input ");
                editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT);
            }
        }
    }


    private void initView() {
        String edittext1 = null;
        String edittext2 = null;
        String edittext3 = null;
        Log.e("test", "initView: " + sharedPreferencesUtil.getString("教育背景"));
        if (sharedPreferencesUtil.getString("教育背景") != null || sharedPreferencesUtil.getString("相关项目经验") != null || sharedPreferencesUtil.getString("自我评价") != null) {
            edittext1 = sharedPreferencesUtil.getString("教育背景");
            edittext2 = sharedPreferencesUtil.getString("相关项目经验");
            edittext3 = sharedPreferencesUtil.getString("自我评价");
        }
        MyRelativeLayout relativeLayout1 = new MyRelativeLayout("#4FC3F7", "教育背景", "0/100", edittext1);
        MyRelativeLayout relativeLayout2 = new MyRelativeLayout("#FFEE58", "相关项目经验", "0/200", edittext2);
        MyRelativeLayout relativeLayout3 = new MyRelativeLayout("#FF6C72", "自我评价", "0/100", edittext3);
        relativeLayouts.add(relativeLayout1);
        relativeLayouts.add(relativeLayout2);
        relativeLayouts.add(relativeLayout3);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
        View v = getCurrentFocus();
        if (edit_status == 0) {
            hideSoftInput(v.getWindowToken());
        } else {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                if (isShouldHideInput(v, ev)) {
                    hideSoftInput(v.getWindowToken());
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, 0);
        }
    }
}
