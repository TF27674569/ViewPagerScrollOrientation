package org.pager.scroll;

/**
 * description：
 * <p/>
 * Created by TIAN FENG on 2018/12/3
 * QQ：27674569
 * Email: 27674569@qq.com
 * Version：1.0
 */
public interface OnScrollIndexChangeListener {

    /**
     * @param currentPosition  当前页
     * @param nextPosition 下一页
     * @param positionOffset 滚动百分比
     * @param positionOffsetPixels 滚动像素
     */
    void onScrollChange(int currentPosition, int nextPosition, float positionOffset,int positionOffsetPixels);
}
