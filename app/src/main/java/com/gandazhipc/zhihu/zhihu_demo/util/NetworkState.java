package com.gandazhipc.zhihu.zhihu_demo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by gandazhiPc on 2017/3/9.
 */

public class NetworkState {

    //检查是否连接到网络
    public static boolean networkConnected(Context context){
        if (context != null){
            ConnectivityManager manager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }

    //检查是否wifi连接
    public static boolean wifiConnected(Context context){
        if (context != null){
            ConnectivityManager manger = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            NetworkInfo info = manger.getActiveNetworkInfo();
            if (info.getType() == ConnectivityManager.TYPE_WIFI){
                return info.isAvailable();
            }
        }
        return false;
    }

    //检查是否手机数据
    public static boolean mobileDataConnected(Context context){
        if (context != null){
            ConnectivityManager manager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info.getType() == ConnectivityManager.TYPE_MOBILE){
                return true;
            }
        }
        return false;
    }
}
