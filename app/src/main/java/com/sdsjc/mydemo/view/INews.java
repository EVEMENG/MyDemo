package com.sdsjc.mydemo.view;


import com.sdsjc.mydemo.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: MyDemoList
 * @Package: com.zmz.mydemolist.model
 * @ClassName: INews
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 8:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 8:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface INews {
    //搜索商品 回调结果
    void GetGoods(List<NewsBean.ResultBean> dlist);
}
