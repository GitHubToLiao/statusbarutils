package com.example.as.statusbarutils;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MyScrollView myScrollView;
    private ImageView mImage_View;
    private View mTitle_Bar;

    private int mImageHeight;
    private int mTitleBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.setActivityTranslucent(this);


        myScrollView = (MyScrollView) findViewById(R.id.scroll_view);
        mImage_View = (ImageView) findViewById(R.id.image_view);
        mTitle_Bar  =findViewById(R.id.title_bar);
        mTitle_Bar.getBackground().setAlpha(0);
        mImage_View.post(new Runnable() {
            @Override
            public void run() {
                mImageHeight =mImage_View.getMeasuredHeight();
            }
        });

        mTitle_Bar.post(new Runnable() {
            @Override
            public void run() {
                mTitleBarHeight =mTitle_Bar.getMeasuredHeight();
            }
        });
        myScrollView.setOnScrollChangeListener(new MyScrollView.ScrollChangeListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                if(mImageHeight <=0)return;
                float alpha =(float) t/(mImageHeight-mTitleBarHeight);

                if(alpha <=0){
                    alpha =0;
                }
                if(alpha>1){
                    alpha=1;
                }
                mTitle_Bar.getBackground().setAlpha((int)(alpha*255));
            }
        });



    }
}
