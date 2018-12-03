package com.org.orientation;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.pager.scroll.OnScrollIndexChangeListener;
import org.pager.scroll.ViewPagerScrollOrientation;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewPager);

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return false;
            }
        });


        ViewPagerScrollOrientation pagerScrollOrientation = new ViewPagerScrollOrientation(mViewPager);

        pagerScrollOrientation.setOnScrollIndexChangeListener(new OnScrollIndexChangeListener() {
            @Override
            public void onScrollChange(int currentPosition, int nextPosition, float positionOffset, int positionOffsetPixels) {
                /**
                 * @param currentPosition  当前页
                 * @param nextPosition 下一页
                 * @param positionOffset 滚动百分比
                 * @param positionOffsetPixels 滚动像素
                 */
            }
        });
    }
}
