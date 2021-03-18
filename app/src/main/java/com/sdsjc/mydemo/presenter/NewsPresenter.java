package com.sdsjc.mydemo.presenter;

import android.content.Context;

import com.sdsjc.mydemo.model.NewsModel;
import com.sdsjc.mydemo.model.INewsModel;
import com.sdsjc.mydemo.view.INews;

/**
 * @ProjectName: MyDemoList
 * @Package: com.zmz.mydemolist.presenter
 * @ClassName: NewsPresenter
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 10:25
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 10:25
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class NewsPresenter implements INewsPresenter {
    private INews iNews;
    private INewsModel iNewsModel;
    public NewsPresenter(INews iNews, Context context) {
        this.iNews = iNews;
        iNewsModel =new NewsModel(context, iNews);
    }
    @Override
    public void GetMyGoods(Context context, int p) {
        iNewsModel.getGoods(context, iNews,p);
    }
}
