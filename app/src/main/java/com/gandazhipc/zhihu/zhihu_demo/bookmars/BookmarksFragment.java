package com.gandazhipc.zhihu.zhihu_demo.bookmars;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gandazhipc.zhihu.zhihu_demo.R;
import com.gandazhipc.zhihu.zhihu_demo.adapter.BookmarsAdapter;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.homepage.ZhihuDailyContact;

import java.util.ArrayList;

/**
 * Created by gandazhi on 17-3-14.
 */

public class BookmarksFragment extends Fragment implements BookmarksContract.View{

    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private BookmarsAdapter adapter;
    private BookmarksContract.Presenter presenter;

    public BookmarksFragment(){}

    public static BookmarksFragment newInstance(){
        return new BookmarksFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);

        initView(view);

        setHasOptionsMenu(true);

        presenter.loadResults(false);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadResults(true);
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_bookmarks,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList, ArrayList<Integer> types) {

    }

    @Override
    public void notifyDataChange() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(BookmarksContract.Presenter presenter) {
        if (presenter != null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        refreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.refreshLayout));
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }
}
