package com.gandazhipc.zhihu.zhihu_demo.homepage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gandazhipc.zhihu.zhihu_demo.R;
import com.gandazhipc.zhihu.zhihu_demo.adapter.MainPagerAdapter;

/**
 * Created by gandazhi on 17-3-12.
 */

public class MainFragment extends Fragment {

    private Context context;
    private MainPagerAdapter adapter;

    private TabLayout tabLayout;

    //果壳和豆瓣暂时没写
    private ZhihuDailyFragment zhihuDailyFragment;

    //果壳和豆瓣暂时没写
    private ZhihuDailyPresenter zhihuDailyPresenter;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = context;

        //fragment恢复状态  果壳和豆瓣暂时没写
        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            zhihuDailyFragment = ((ZhihuDailyFragment) manager.getFragment(savedInstanceState, "zhihu"));
        } else {
            //创建view实列
            zhihuDailyFragment = ((ZhihuDailyFragment) ZhihuDailyFragment.newInstance());
        }

        //创建presenter实列  果壳和豆瓣暂时没写
        zhihuDailyPresenter = new ZhihuDailyPresenter(context, zhihuDailyFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //初始化控件
        initView(view);

        //显示菜单

        return view;
    }

    private void initView(View view) {
        tabLayout = ((TabLayout) view.findViewById(R.id.tab_layout));
        ViewPager viewPager = ((ViewPager) view.findViewById(R.id.view_pager));
        //设置离线数为3
        viewPager.setOffscreenPageLimit(3);

        //果壳，豆瓣暂时没有写
        adapter = new MainPagerAdapter(getChildFragmentManager(),
                context,
                zhihuDailyFragment);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public MainPagerAdapter getAdapter() {
        return adapter;
    }
}
