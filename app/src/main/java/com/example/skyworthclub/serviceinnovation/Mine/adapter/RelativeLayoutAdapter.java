package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.nfc.Tag;
import android.os.IBinder;
import android.os.Looper;
import android.renderscript.ScriptGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.utils.SharedPreferencesUtil;
import com.example.skyworthclub.serviceinnovation.Mine.utils.MyRelativeLayout;
import com.example.skyworthclub.serviceinnovation.Mine.utils.TestClass;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by 26792 on 2018/3/14.
 */

public class RelativeLayoutAdapter extends RecyclerView.Adapter<RelativeLayoutAdapter.ViewHolder> {
    private List<MyRelativeLayout> mrelativeLayouts;
    private RecyclerView mrecyclerView;
    private int status;
    private TextWatcher mTextWatcher;
    boolean show = true;
    View viewitem;
    SharedPreferencesUtil sharedPreferencesUtil;

    public RelativeLayoutAdapter(List<MyRelativeLayout> relativeLayouts, int status, RecyclerView recyclerView) {
        mrelativeLayouts = relativeLayouts;
        mrecyclerView = recyclerView;
        this.status = status;
        sharedPreferencesUtil = new SharedPreferencesUtil(mrecyclerView.getContext());
    }


    @Override
    public RelativeLayoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
//        edittext与recyclerview滑动冲突解决
        holder.meditText.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //触摸的是EditText而且当前EditText能够滚动则将事件交给EditText处理。否则将事件交由其父类处理
                if ((view.getId() == R.id.mine_resume_et && canVerticalScroll(holder.meditText))) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);

                    }
                } else {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }

            /**
             * EditText竖直方向能否够滚动
             *
             * @param editText 须要推断的EditText
             * @return true：能够滚动   false：不能够滚动
             */
            private boolean canVerticalScroll(EditText editText) {
                //滚动的距离
                int scrollY = editText.getScrollY();
                //控件内容的总高度
                int scrollRange = editText.getLayout().getHeight();
                //控件实际显示的高度
                int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() - editText.getCompoundPaddingBottom();
                //控件内容总高度与实际显示高度的差值
                int scrollDifference = scrollRange - scrollExtent;

                if (scrollDifference == 0) {
                    return false;
                }

                return (scrollY > 0) || (scrollY < scrollDifference - 1);
            }
        });

        mTextWatcher = new TextWatcher() {
            private CharSequence temp;
            private int editstar;
            private int editend;
            private int position;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("test", "afterTextChanged: in");
                editstar = holder.meditText.getSelectionStart();
                editend = holder.meditText.getSelectionEnd();
                position = holder.getAdapterPosition();
                Toast.makeText(view.getContext(), "test" + position, Toast.LENGTH_SHORT).show();
                if (position != 1) {
                    if (temp.length() != 0) {
                        holder.mbottom_tv.setText(String.format(view.getContext().getResources().getString(R.string.resume_tv_first), temp.length()));
                    }
                    if (temp.length() >= 100) {
                        if (show) {
                            Toast.makeText(view.getContext(), "不可以超过100字", Toast.LENGTH_SHORT).show();
                            show = false;
                        } else {
                            show = true;
                        }
                        s.delete(editstar - 1, editend);
                        int tempSelection = editstar;
                        holder.meditText.setText(s.toString());
                        holder.meditText.setSelection(tempSelection);

                    }

                } else {
                    if (temp.length() != 0) {
                        Log.e("test", "afterTextChanged: " + temp.length());
                        holder.mbottom_tv.setText(String.format(view.getContext().getResources().getString(R.string.resume_tv_second), temp.length()));
                    }
                    if (temp.length() >= 200) {
                        if (show) {
                            Toast.makeText(view.getContext(), "不可以超过200字", Toast.LENGTH_SHORT).show();
                            show = false;
                        } else {
                            show = true;
                        }
                        s.delete(editstar - 1, editend);
                        int tempSelection = editstar;
                        holder.meditText.setText(s.toString());
                        holder.meditText.setSelection(tempSelection);
                    }
                }
                sharedPreferencesUtil.putString("string_length" + position, String.valueOf(temp.length()));
                Log.e("test", "string_length: " + String.valueOf(temp.length()));
            }
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(RelativeLayoutAdapter.ViewHolder holder, int position) {
        MyRelativeLayout relativeLayout = mrelativeLayouts.get(position);
        holder.mview.setBackgroundColor(Color.parseColor(relativeLayout.getMcolor()));
        holder.mtextView.setText(relativeLayout.getMtitle_tv());
        holder.mbottom_tv.setText(relativeLayout.getMbottom_tv());
//        初始化字数
        String string_length = sharedPreferencesUtil.getString("string_length" + position);
        if (string_length != null) {
            int length = Integer.valueOf(string_length);
            Log.e("test", "length " + length);
            holder.mbottom_tv.setText(String.format(mrecyclerView.getResources().getString(R.string.resume_tv_first), length));
        }
        holder.meditText.setText(relativeLayout.getEditText());
//        为edittext设置是否可点击
        holder.meditText.addTextChangedListener(mTextWatcher);
    }

    @Override
    public int getItemCount() {
        return mrelativeLayouts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mview;
        TextView mtextView;
        EditText meditText;
        TextView mbottom_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            mview = itemView.findViewById(R.id.mine_resume_spot);
            mtextView = itemView.findViewById(R.id.mine_resume_textview);
            meditText = itemView.findViewById(R.id.mine_resume_et);
            mbottom_tv = itemView.findViewById(R.id.mine_resume_number);
        }
    }
    /**
     * 判断当前线程是否为主线程
     *
     * @return
     */
    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
