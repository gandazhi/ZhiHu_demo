package com.gandazhipc.zhihu.zhihu_demo.search;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.gandazhipc.zhihu.zhihu_demo.R;
import com.gandazhipc.zhihu.zhihu_demo.adapter.BookmarksAdapter;
import com.gandazhipc.zhihu.zhihu_demo.bean.BeanType;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.interfaze.OnRecyclerViewOnClickListener;

import java.util.ArrayList;

/**
 * Created by gandazhi on 17-3-16.
 */

public class SearchFragment extends Fragment implements SearchContract.View{

    private SearchContract.Presenter presenter;

    private SearchView searchView;
    private RecyclerView recyclerView;
    private ContentLoadingProgressBar progressBar;

    private BookmarksAdapter adapter;

    public static SearchFragment newInstance(){
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_bookmarks,container,false);

        initView(view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.loadResults(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.loadResults(newText);
                return true;
            }
        });

        return view;
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        if (presenter != presenter){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = ((Toolbar) view.findViewById(R.id.toolBar));
        ((SearchActivity)(getActivity())).setSupportActionBar(toolbar);
        ((SearchActivity)(getActivity())).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchView = ((SearchView) view.findViewById(R.id.searchView));
        searchView.setIconified(false);

        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        progressBar = ((ContentLoadingProgressBar) view.findViewById(R.id.progressBar));
    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList, ArrayList<Integer> types) {
        if (adapter == null){
            adapter = new BookmarksAdapter(getActivity(),zhihuList,types);
            adapter.setItemListener(new OnRecyclerViewOnClickListener() {
                @Override
                public void OnItemClick(View v, int position) {
                    int type = recyclerView.findViewHolderForAdapterPosition(position).getItemViewType();
                    if (type == BookmarksAdapter.TYPE_ZHIHU_NORMAL){
                        presenter.startReading(BeanType.TYPE_ZHIHU,position);
                    }
                }

                @Override
                public void onClick(View v) {

                }
            });
            recyclerView.setAdapter(adapter);
        }
        else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
