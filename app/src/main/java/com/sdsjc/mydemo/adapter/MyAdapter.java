package com.sdsjc.mydemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdsjc.mydemo.R;
import com.sdsjc.mydemo.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: MyDemo
 * @Package: com.sdsjc.mydemo.adapter
 * @ClassName: MyAdapter
 * @Description: java类作用描述
 * @Author: zmz
 * @CreateDate: 2021/3/18 14:02
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/3/18 14:02
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<NewsBean.ResultBean> mList;
    Context mContext;

    public MyAdapter(Context context, List<NewsBean.ResultBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String title = mList.get(position).getTitle();
        String imgUrl = mList.get(position).getImage();
        String content = mList.get(position).getPath();
        //没有图片链接的数据不做展示
        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(mContext).load(imgUrl).into(holder.img);
        } else {
            holder.img.setVisibility(View.GONE);
        }
        holder.tvTilte.setText(title);
        holder.tvContent.setText(content);
    }

    /**
     * 数据刷新
     */
    public void refreshData() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTilte;
        TextView tvContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = getView(itemView, R.id.item_img);
            tvTilte = getView(itemView, R.id.item_title);
            tvContent = getView(itemView, R.id.item_content);
        }
    }

    private <T extends View> T getView(View view, int id) {
        return (T) view.findViewById(id);
    }
}
