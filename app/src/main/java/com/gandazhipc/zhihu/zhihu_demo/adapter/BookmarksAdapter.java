package com.gandazhipc.zhihu.zhihu_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gandazhipc.zhihu.zhihu_demo.R;
import com.gandazhipc.zhihu.zhihu_demo.bean.ZhihuDailyNews;
import com.gandazhipc.zhihu.zhihu_demo.interfaze.OnRecyclerViewOnClickListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by gandazhi on 17-3-14.
 */

public class BookmarksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    //guokelist

    //doubanlist

    //zhihulist
    private final List<ZhihuDailyNews.Question> zhihulist;

    private List<Integer> types;

    private OnRecyclerViewOnClickListener listener;

    public static final int TYPE_ZHIHU_NORMAL = 0;
    public static final int TYPE_ZHIHU_WITH_HEADER = 1;

    //guoke


    //douban


    //guoke douban haven't written
    public BookmarksAdapter(Context context, ArrayList<ZhihuDailyNews.Question> zhihulist,
                            ArrayList<Integer> types){
        this.context = context;
        this.inflater = LayoutInflater.from(context);

        this.zhihulist = zhihulist;

        //types.size = zhihuList.size + guokeList.size + doubanList.size
        this.types = types;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_ZHIHU_NORMAL:
                return new NormalViewHolder(inflater.inflate(R.layout.home_list_item_layout,parent,false),this.listener);
        }
        return new WithTypeViewHolder(inflater.inflate(R.layout.bookmars_header,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (types.get(position)){
            case TYPE_ZHIHU_WITH_HEADER:
                ((WithTypeViewHolder)holder).txetViewType.setText(context.getResources().getString(R.string.zhihu_daily));
                break;
            case TYPE_ZHIHU_NORMAL:
                if (!zhihulist.isEmpty()){
                    ZhihuDailyNews.Question q = zhihulist.get(position - 1);

                    Glide.with(context)
                            .load(q.getImages().get(0))
                            .placeholder(R.drawable.placeholder)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .error(R.drawable.placeholder)
                            .centerCrop()
                            .into(((NormalViewHolder)holder).imageView);

                    ((NormalViewHolder)holder).textViewTitle.setText(q.getTitle());
                }

                break;

            default:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }



    @Override
    public int getItemCount() {
        return types.size();
    }

    public void setItemListener(OnRecyclerViewOnClickListener listener){
        this.listener = listener;
    }


    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textViewTitle;
        OnRecyclerViewOnClickListener listener;

        public NormalViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.imageViewCover));
            textViewTitle = ((TextView) itemView.findViewById(R.id.textViewTitle));
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.OnItemClick(v,getPosition());
            }
        }
    }

    public class WithTypeViewHolder extends RecyclerView.ViewHolder{

        TextView txetViewType;

        public WithTypeViewHolder(View itemView) {
            super(itemView);
            txetViewType = ((TextView) itemView.findViewById(R.id.textViewType));
        }
    }
}



