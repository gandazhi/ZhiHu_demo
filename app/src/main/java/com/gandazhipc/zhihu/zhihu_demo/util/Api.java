package com.gandazhipc.zhihu.zhihu_demo.util;

/**
 * Created by gandazhiPc on 2017/3/9.
 */

public class Api {

    //消息内容获取离线下载
    //在最新消息中获取到id，拼接到NEWS后，可以获得对应JSON格式的内容
    public static final String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news";

    //过往消息
    //查询之前的消息在before后面加上时间，如20170205
    //知乎日报在2013年5月19日时建立，时间不能小于20130520
    public static final String ZHIHU_HISTORY = "http://news-at.zhihu.com/api/4/news/before";

    //获取果壳精选的文章列表，通过组合对应的参数成为完整的url
    public static final String GUOKE_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=25&ad=1";

    //获取果壳文章的具体信息 V1
    public static final String GUOKR_ARTICLE_LINK_V1 = "http://jingxuan.guokr.com/pick/";

    //豆瓣一刻
    //根据日期查询消息列表
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    //获取文章具体内容
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";
}
