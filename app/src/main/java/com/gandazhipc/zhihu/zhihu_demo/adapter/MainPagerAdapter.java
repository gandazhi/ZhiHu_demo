package com.gandazhipc.zhihu.zhihu_demo.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gandazhipc.zhihu.zhihu_demo.homepage.ZhihuDailyFragment;

/**
 * Created by gandazhi on 17-3-12.
 */

public class MainPagerAdapter extends PagerAdapter{
    public MainPagerAdapter(FragmentManager childFragmentManager, Context context, ZhihuDailyFragment zhihuDailyFragment) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
