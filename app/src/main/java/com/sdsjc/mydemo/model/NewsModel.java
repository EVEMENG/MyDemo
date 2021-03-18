package com.sdsjc.mydemo.model;

import android.content.Context;
import android.os.Handler;
import android.os.Message;


import com.google.gson.Gson;
import com.sdsjc.mydemo.bean.NewsBean;
import com.sdsjc.mydemo.view.INews;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @ProjectName: MyDemoList
 * @Package: com.zmz.mydemolist.model
 * @ClassName: NewsModel
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 10:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 10:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class NewsModel implements INewsModel {
    Context context;
    INews iNews;
    private List<NewsBean.ResultBean> data;

    public NewsModel(Context context, INews iNews) {
        this.context = context;
        this.iNews = iNews;
    }

    @Override
    public void getGoods(Context context, INews iNews, int page) {
        //请求网路数据
        getHttpGoods(page);
    }

    private void getHttpGoods(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", page + "");
        String url = "https://api.apiopen.top/getWangYiNews?count=10";
        OkHttpUtils.post().url(url).addParams("page", page + "").build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                String string1 = response.body().string();

                Message message = new Message();
                message.obj = string1;
                message.what = 0;
                handler.sendMessage(message);
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Object response, int id) {
            }
        });
//        OkHttp3Utils.doPost(Api.SHOP, map, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//                String string1 = response.body().string();
//
//                Message message = new Message();
//                message.obj = string1;
//                message.what = 0;
//                handler.sendMessage(message);
//
//            }
//        });
//        String string1 = "{" +
//                "\t\"code\": \"00\"," +
//                "\t\"msg\": \"数据获取成功\"," +
//                "\t\"data\": [{" +
//                "\t\t\t\"title\": \"标题1\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题2\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题3\"," +
//                "\t\t\t\"content\": \"这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题4\"," +
//                "\t\t\t\"content\": \"这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题5\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题6\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题7\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题8\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题9\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}," +
//                "\t\t{" +
//                "\t\t\t\"title\": \"标题10\"," +
//                "\t\t\t\"content\": \"这里是内容描述这里是内容描述这里是内容描述\"," +
//                "\t\t\t\"imgurl\": \"\"" +
//                "\t\t}" +
//                "\t]" +
//                "}";
//        Message message = new Message();
//        message.obj = string1;
//        message.what = 0;
//        handler.sendMessage(message);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String string1 = (String) msg.obj;
                    Gson gson = new Gson();
                    NewsBean newsBean = gson.fromJson(string1, NewsBean.class);
                    data = newsBean.getResult();
                    iNews.GetGoods(data);
                    break;
            }
        }
    };
}
