package com.gandazhipc.zhihu.zhihu_demo.bean;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gandazhipc.zhihu.zhihu_demo.app.VolleySingleton;
import com.gandazhipc.zhihu.zhihu_demo.interfaze.OnStringListener;

/**
 * Created by gandazhiPc on 2017/3/8.
 */

public class StringModelImpl {

    private Context context;

    public StringModelImpl(Context context) {
        this.context = context;
    }

    public void load(String url, final OnStringListener listener){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError);
            }
        });

        VolleySingleton.getVolleySingleton(request);
    }
}
