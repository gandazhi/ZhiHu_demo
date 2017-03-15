package com.gandazhipc.zhihu.zhihu_demo.bookmars;

import com.gandazhipc.zhihu.zhihu_demo.BasePresenter;
import com.gandazhipc.zhihu.zhihu_demo.BaseView;
import com.gandazhipc.zhihu.zhihu_demo.bean.BeanType;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.homepage.ZhihuDailyContact;

import java.util.ArrayList;

/**
 * Created by gandazhi on 17-3-14.
 */

public class BookmarsContract {

    interface View extends BaseView<ZhihuDailyContact.Presenter>{

        //douban guoke haven't written
        void showResults (ArrayList<ZhihuDailyNews.Question> zhihuList,
                          ArrayList<Integer> types);

        void notifyDataChange();

        void showLoading();

        void stopLoading();

    }

    interface Presenter extends BasePresenter{

        void loadResults(boolean refresh);

        void startReading(BeanType type, int position);

        void checkForFreshData();

        void feelLuck();
    }
}
