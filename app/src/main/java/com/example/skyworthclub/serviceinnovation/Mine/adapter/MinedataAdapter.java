package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.utils.SharedPreferencesUtil;
import com.example.skyworthclub.serviceinnovation.Mine.utils.MineData;
import com.example.skyworthclub.serviceinnovation.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by 26792 on 2018/3/17.
 */

public class MinedataAdapter extends RecyclerView.Adapter<MinedataAdapter.ViewHolder> {
    private Context context;
    private final List<MineData> mineDatas;
    private String[] sexArry = new String[]{"女", "男"};
    private String editTexts_content;
    SharedPreferencesUtil sharedPreferencesUtil;
    TextWatcher textWatcher;
    LinearLayoutManager linearLayoutManager;
    private int etFocusPos = 0;//edittext位置
    EditText[] editTextArrayList = new EditText[12];//构建数组进行跳转

    public MinedataAdapter(List<MineData> mineData, Context context, LinearLayoutManager layoutManager) {
        this.mineDatas = mineData;
        this.context = context;
        sharedPreferencesUtil = new SharedPreferencesUtil(context);
        this.linearLayoutManager = layoutManager;
    }

    @Override
    public MinedataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_data_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.editTexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                switch (position) {
                    case 1: {
                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                holder.editTexts.setText(sexArry[which]);
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                    }
                    default:
                        break;
                }
            }
        });
        holder.editTexts.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                int position = holder.getAdapterPosition();
                Log.e("test", "onEditorAction:holder.getAdapterPosition()" + holder.getAdapterPosition());
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    editTextArrayList[position + 1].setFocusable(true);
                    editTextArrayList[position + 1].setFocusableInTouchMode(true);
                    editTextArrayList[position + 1].requestFocus();
                    editTextArrayList[position + 1].setSelection(editTextArrayList[position + 1].getText().length());//若editText有内容就将光标移动到文本末尾

                }

                return false;
            }
        });
        textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String s1 = s.toString();
//                每次修改后自动保存
                etFocusPos = holder.getAdapterPosition();//获取当前position
                MineData mineData = mineDatas.get(etFocusPos);
                //每次修改文字后，保存在数据集合中
                Log.e("test", "index=" + etFocusPos + "name" + mineData.getName() + "save=" + s1);
                sharedPreferencesUtil.putString(mineData.getName(), s1);
            }
        };

        return holder;
    }


    @Override
    public void onBindViewHolder(MinedataAdapter.ViewHolder holder, int position) {
        MineData mineData = mineDatas.get(position);
        holder.setIsRecyclable(false);
        holder.textView.setText(mineData.getName());
        if (holder.editTexts.getTag() != (Integer) 0) {
            holder.editTexts.setTag(position);
        }
        holder.views.setBackgroundColor(Color.parseColor(mineData.getMcolor()));
        editTexts_content = holder.editTexts.getText().toString();
        Log.e("test", "onBindViewHolder: " + editTexts_content + "POSITION" + position);
        if (mineData.getMedittext() != null && (Integer) position == holder.editTexts.getTag()) {

            if (sharedPreferencesUtil.getString(mineData.getName()) != null) {
                holder.editTexts.setText(sharedPreferencesUtil.getString(mineData.getName()));
            } else {
                holder.editTexts.setText(mineData.getMedittext());
            }

        }
        holder.editTexts.addTextChangedListener(textWatcher);
        holder.editTexts.setVisibility(View.VISIBLE);
        editTextArrayList[position + 1] = holder.editTexts;//初始化数组
    }


    @Override
    public int getItemCount() {
        return mineDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public EditText editTexts;
        private TextView textView;
        private View views;

        public ViewHolder(View itemView) {
            super(itemView);
            editTexts = itemView.findViewById(R.id.mine_data_edittext);
            textView = itemView.findViewById(R.id.mine_data_moudle);
            views = itemView.findViewById(R.id.mine_data_view);
        }
    }
}
