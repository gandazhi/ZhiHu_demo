package com.gandazhipc.zhihu.zhihu_demo.search;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gandazhipc.zhihu.zhihu_demo.R;

/**
 * Created by gandazhi on 17-3-16.
 */

public class SearchActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);

        SearchFragment fragment = SearchFragment.newInstance();

        FragmentManager manger = getFragmentManager();
        FragmentTransaction transaction = manger.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();




    }
}
