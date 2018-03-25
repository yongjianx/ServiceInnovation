package com.example.skyworthclub.serviceinnovation.Homepage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by skyworthclub on 2018/3/20.
 */

public class SearchView extends ViewGroup {
    //屏幕宽度
    private int screenWidth;
    //横向间距
    private int horizontalSpace;
    //纵向间距
    private int verticalSpace;

    public SearchView(Context context){
        super(context);
        init();
    }

    public SearchView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public SearchView(Context context, AttributeSet attributeSet, int degStyle){
        super(context, attributeSet, degStyle);
        init();
    }

    private void init(){
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
    }

    public void setSpace(int horizontalSpace, int verticalSpace){
        this.horizontalSpace = horizontalSpace;
        this.verticalSpace = verticalSpace;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int totalWidth = 0;
        int totalHeight = 0;
        int tempHeight = 0;
        int lineCount = 1;

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        for (int i=0; i<getChildCount(); i++){
            View childView = getChildAt(i);
            int measureHeight = childView.getMeasuredHeight();
            int measureWidth = childView.getMeasuredWidth();

            tempHeight = (measureHeight > tempHeight)? measureHeight:tempHeight;
            //只有一行的时候赋值
            if (lineCount == 1)
                totalHeight = tempHeight;
            //大于屏幕宽度
            if ((measureWidth+totalWidth+horizontalSpace) > screenWidth){
                totalWidth = 0;
                totalHeight += tempHeight + verticalSpace;
                tempHeight = 0;
                lineCount++;
            }
            totalWidth += measureWidth + horizontalSpace;
        }

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200, 40);
        }else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200, heightSize);
        }else
            setMeasuredDimension(widthSize, resolveSize(totalHeight, heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int totalHeight = 0;
        int totalWidth = 0;
        int tempHeight = 0;

        int count = getChildCount();
        for (int i=0; i<count; i++){
            View childView = getChildAt(i);

            int measureWidth = childView.getMeasuredWidth();
            int measureHeight = childView.getMeasuredHeight();

            tempHeight = (measureHeight > tempHeight)? measureHeight:tempHeight;
            //大于屏幕宽度
            if ((measureWidth+totalWidth+horizontalSpace) > screenWidth){
                totalWidth = 0;
                totalHeight += tempHeight + verticalSpace;
                tempHeight = 0;
            }

            childView.layout(totalWidth+horizontalSpace, totalHeight,
                    measureWidth+totalWidth+horizontalSpace, totalHeight+measureHeight);

            totalWidth += measureWidth + horizontalSpace;
        }

    }
}
