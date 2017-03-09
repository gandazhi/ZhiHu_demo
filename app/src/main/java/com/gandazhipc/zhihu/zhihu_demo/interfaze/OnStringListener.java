package com.gandazhipc.zhihu.zhihu_demo.interfaze;

import com.android.volley.VolleyError;


/**
 * Created by gandazhiPc on 2017/3/8.
 */

public interface OnStringListener {
    /**
     * 请求成功时调用
     * @param result
     */
    void onSuccess(String result);

    /**
     * 请求失败时调用
     * @param error
     */
    void onError(VolleyError error);
}
