package com.gandazhipc.zhihu.zhihu_demo.homepage;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by gandazhiPc on 2017/3/8.
 */

public class ZhihuDailyFragment extends Fragment implements ZhihuDailyContact.View{

    public ZhihuDailyFragment(){}

    public static ZhihuDailyFragment newInstance(){
        return new ZhihuDailyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter(ZhihuDailyContact.Presenter presenter) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> list) {

    }

    @Override
    public void showPickDialog() {

    }
}
