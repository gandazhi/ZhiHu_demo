package com.gandazhipc.zhihu.zhihu_demo.search;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import com.gandazhipc.zhihu.zhihu_demo.bean.BeanType;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.db.DatabaseHelper;
import com.google.gson.Gson;

import java.util.ArrayList;

import static com.gandazhipc.zhihu.zhihu_demo.adapter.BookmarksAdapter.TYPE_ZHIHU_NORMAL;
import static com.gandazhipc.zhihu.zhihu_demo.adapter.BookmarksAdapter.TYPE_ZHIHU_WITH_HEADER;

/**
 * Created by gandazhi on 17-3-17.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View view;
    private Context context;
    private Gson gson;

    //douban guoke haven't written
    private ArrayList<ZhihuDailyNews.Question> zhihuList;

    private ArrayList<Integer> types;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public SearchPresenter(Context context,SearchContract.View view){
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);

        gson = new Gson();
        dbHelper = new DatabaseHelper(context,"History.db",null,5);
        db = dbHelper.getWritableDatabase();

        zhihuList = new ArrayList<>();
        types = new ArrayList<>();
    }
    @Override
    public void start() {

    }

    @Override
    public void loadResults(String queryWords) {

        zhihuList.clear();
        types.clear();

        types.add(TYPE_ZHIHU_WITH_HEADER);
        Cursor cursor = db.rawQuery("select * from Zhihu where bookmark = 1 and zhihu_news like '%" + queryWords + '%',null);

        if (cursor.moveToFirst()){
            //zhihu
            do {
                ZhihuDailyNews.Question question = gson.fromJson(cursor.getString(cursor.getColumnIndex("zhihu_news")),ZhihuDailyNews.Question.class);
                zhihuList.add(question);
                types.add(TYPE_ZHIHU_NORMAL);
            }while (cursor.moveToNext());

            //douban

            //guoke

            cursor.close();

            view.showResults(zhihuList,types);
        }
    }

    @Override
    public void startReading(BeanType type, int position) {

    }
}
