package com.gandazhipc.zhihu.zhihu_demo.interfaze;

import android.view.View;

/**
 * Created by gandazhi on 17-3-14.
 */

public interface OnRecyclerViewOnClickListener extends View.OnClickListener {
    void OnItemClick(View v,int position);
}
