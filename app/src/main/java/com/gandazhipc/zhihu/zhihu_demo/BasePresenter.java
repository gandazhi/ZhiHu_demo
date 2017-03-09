package com.gandazhipc.zhihu.zhihu_demo;

/**
 * Created by gandazhiPc on 2017/3/8.
 */

public interface BasePresenter {

    //获取数据并改变界面显示,在todo-mvp的项目中的调用时机为fragment中的onResume()
    void start();
}
