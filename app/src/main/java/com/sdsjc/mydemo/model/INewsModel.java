package com.sdsjc.mydemo.model;

import android.content.Context;

import com.sdsjc.mydemo.view.INews;


/**
 * @ProjectName: MyDemoList
 * @Package: com.zmz.mydemolist.model
 * @ClassName: INewsModel
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 14:56
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 14:56
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface INewsModel {
    void getGoods(Context context, INews iNews, int page);
}
