package com.gandazhipc.zhihu.zhihu_demo;

import android.view.View;

/**
 * Created by gandazhiPc on 2017/3/8.
 */

public interface BaseView<T> {
    //为view设置Presenter
    void setPresenter(T presenter);

    //初始化界面控件
    void initView(View view);

}
