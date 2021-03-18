package com.sdsjc.mydemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.sdsjc.mydemo.adapter.MyAdapter;
import com.sdsjc.mydemo.bean.NewsBean;
import com.sdsjc.mydemo.presenter.NewsPresenter;
import com.sdsjc.mydemo.presenter.INewsPresenter;
import com.sdsjc.mydemo.view.INews;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: MyDemo
 * @Package: com.sdsjc.mydemo
 * @ClassName: MainActivity
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 17:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 17:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MainActivity extends AppCompatActivity implements INews {
    private INewsPresenter presenter;
    int page = 1;
    Handler handler = new Handler();
    private List<NewsBean.ResultBean> data;
    @BindView(R.id.pr)
    PullLoadMoreRecyclerView pr;
    private RecyclerView mRecyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new NewsPresenter(this, MainActivity.this);
        presenter.GetMyGoods(MainActivity.this, page);
        pr.setPullRefreshEnable(false);//不需要下拉刷新
        pr.setLinearLayout();//线性布局
        //获取mRecyclerView对象
        mRecyclerView = pr.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
    }

    @Override
    public void GetGoods(List<NewsBean.ResultBean> dlist) {
        if (page == 1) {
            data = new ArrayList<NewsBean.ResultBean>();
        }
        for (int i = 0; i < dlist.size(); i++) {
            data.add(dlist.get(i));
        }
        initData(data);
    }

    public void initData(final List<NewsBean.ResultBean> list) {
        if (adapter == null) {
            adapter = new MyAdapter(this, list);
            pr.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        /**
         * 上拉加载更多
         */
        pr.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        presenter.GetMyGoods(MainActivity.this, page);
                        pr.setPullLoadMoreCompleted();
                    }
                }, 2000);
            }
        });
    }
}
