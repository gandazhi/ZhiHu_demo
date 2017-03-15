package com.gandazhipc.zhihu.zhihu_demo.bookmars;

import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.homepage.ZhihuDailyContact;

import java.util.ArrayList;

/**
 * Created by gandazhi on 17-3-14.
 */

public class BookmarsFragment extends Fragment implements BookmarsContract.View{

    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    private BookmarsContract.Presenter presenter;

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList, ArrayList<Integer> types) {

    }

    @Override
    public void notifyDataChange() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(ZhihuDailyContact.Presenter presenter) {

    }

    @Override
    public void initView(View view) {

    }
}
