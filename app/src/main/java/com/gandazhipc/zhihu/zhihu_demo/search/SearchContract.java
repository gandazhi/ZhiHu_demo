package com.gandazhipc.zhihu.zhihu_demo.search;

import com.gandazhipc.zhihu.zhihu_demo.BasePresenter;
import com.gandazhipc.zhihu.zhihu_demo.BaseView;
import com.gandazhipc.zhihu.zhihu_demo.bean.BeanType;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.homepage.ZhihuDailyContact;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by gandazhi on 17-3-16.
 */

public class SearchContract {

    interface View extends BaseView<SearchContract.Presenter>{

        //douban guoke haven't written
        void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList,
                         ArrayList<Integer> types);

        void showLoading();

        void stopLoading();
    }

    interface Presenter extends BasePresenter{

        void loadResults(String queryWords);

        void startReading(BeanType type,int position);
    }
}
