package com.gandazhipc.zhihu.zhihu_demo.homepage;

import com.gandazhipc.zhihu.zhihu_demo.BasePresenter;
import com.gandazhipc.zhihu.zhihu_demo.BaseView;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by gandazhiPc on 2017/3/8.
 */

public interface ZhihuDailyContact {

    interface View extends BaseView<Presenter>{

        //显示加载或其他类型的错误
        void showError();
        //显示加载
        void showLoading();
        //停止显示加载
        void stopLoading();
        //成功获取数据后，在界面中显示
        void showResults(ArrayList<ZhihuDailyNews.Question> list);
        //显示加载日期
        void showPickDialog();
    }

    interface Presenter extends BasePresenter{

        //请求数据
        void loadPosts(long date,boolean clearing);
        //刷新数据
        void refresh();
        //加载更多文章
        void loadMore(long date);
        //显示详情
        void startReading(int position);
        //随便看看
        void feelLucky();

    }
}
