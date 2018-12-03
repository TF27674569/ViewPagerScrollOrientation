package org.pager.scroll;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * description：
 * <p/>
 * Created by TIAN FENG on 2018/12/3
 * QQ：27674569
 * Email: 27674569@qq.com
 * Version：1.0
 */
public class PageScrollOrientationChangeListener implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    // 是否溢出了一个页面 滑动是否超过一个页面
    private boolean mScrollOverflowOneItem = false;
    // 滚动时的位置
    private int mScrollIndex = 0;

    // 滚动回调
    private OnScrollIndexChangeListener mListener;

    private int mViewPagerMaxCount;

    public PageScrollOrientationChangeListener(ViewPager viewPager, OnScrollIndexChangeListener listener) {
        mViewPager = viewPager;
        mListener = listener;

        PagerAdapter adapter = mViewPager.getAdapter();

        if (adapter == null) {
            throw new IllegalStateException("请先给 viewpager 设置 adapter !");
        }

        mViewPagerMaxCount = adapter.getCount();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        // 滚动超过一页时 position 会重置  positionOffset positionOffsetPixels 都会重新从0开始 直接拿来使用会出现错乱

        // 第一次滚动 并且页面没有划过到第二页 这里主要是过滤第二页
        if (!mScrollOverflowOneItem && mScrollIndex == position) {
            mScrollOverflowOneItem = true;
        }

        if (mScrollOverflowOneItem) {
            onScrollIndexChange(position, position == mViewPagerMaxCount - 1 ? 0 : position + 1, positionOffset, positionOffsetPixels);
        } else {
            // 确定页面超过时 index重置
            mScrollIndex = position;
        }

    }

    private void onScrollIndexChange(int current, int next, float positionOffset, int positionOffsetPixels) {
        if (mListener != null) {
            mListener.onScrollChange(current, next, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        // 滚动完之后重置
        mScrollOverflowOneItem = false;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // state == 1 表示滚动状态 0 默认状态
        if (state == 1) {
            mScrollIndex = mViewPager.getCurrentItem();
        }
    }
}
