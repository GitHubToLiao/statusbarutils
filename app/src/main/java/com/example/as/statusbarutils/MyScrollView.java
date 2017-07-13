package com.example.as.statusbarutils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by as on 2017/7/12.
 */

public class MyScrollView extends ScrollView {
    private ScrollChangeListener mScrollChangeListener;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mScrollChangeListener.onScroll(l,t,oldl,oldt);
    }
    interface ScrollChangeListener{
        void onScroll(int l, int t, int oldl, int oldt);
    }

    public void setOnScrollChangeListener(ScrollChangeListener scrollChangeListener){
        this.mScrollChangeListener = scrollChangeListener;
    }
}
