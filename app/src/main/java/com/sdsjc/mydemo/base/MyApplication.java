package com.sdsjc.mydemo.base;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @ProjectName: MyDemoList
 * @Package: com.zmz.mydemolist.base
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 10:42
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 10:42
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }
}
