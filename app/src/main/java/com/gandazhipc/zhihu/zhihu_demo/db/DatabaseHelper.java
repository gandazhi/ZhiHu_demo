package com.gandazhipc.zhihu.zhihu_demo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gandazhi on 17-3-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db for zhihu
        db.execSQL("create table if not exists Zhihu(" +
                "id integer primary key autoincrement" +
                "zhihu_id integer not null" +
                "zhihu_news text" +
                "zhihu_time real" +
                "zhihu_context text)");

        //db for douban

        //db for guoke

        db.execSQL("alter table Zhihu add column bookmark integer default 0");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion){
            case 1:

                break;
            case 2:
                db.execSQL("create table if not exists Contents(id integer primary key,date integer not null,context not null)");
                break;
            case 3:
                //delete table if exists
                db.execSQL("delete from LatestPosts");
                db.execSQL("delete from Contents");
                db.execSQL("drop table if exists from LatestPosts");
                db.execSQL("drop table if exists from Contents");

               //create a new table of zhihu daily
                db.execSQL("create table if not exists Zhihu(" +
                        "id integer primary key autoincrement" +
                        "zhihu_id integer not null" +
                        "zhihu_news text" +
                        "zhihu_time real" +
                        "zhihu_content text)");

                //create a new table of douban

                //create a new table of guoke

                break;
            case 4:
                db.execSQL("alter table Zhihu add column bookmark integer default 0");
        }

    }
}
