package org.pager.scroll;

import android.support.v4.view.ViewPager;

/**
 * description：
 * <p/>
 * Created by TIAN FENG on 2018/12/3
 * QQ：27674569
 * Email: 27674569@qq.com
 * Version：1.0
 */
public class ViewPagerScrollOrientation{


    private ViewPager mViewPager;

    public ViewPagerScrollOrientation(ViewPager viewPager){
        mViewPager = viewPager;
    }


    public void setOnScrollIndexChangeListener(OnScrollIndexChangeListener listener){
        if (mViewPager == null){
            throw new NullPointerException("viewPager is null!");
        }
        mViewPager.addOnPageChangeListener(new PageScrollOrientationChangeListener(mViewPager,listener));
    }

}
