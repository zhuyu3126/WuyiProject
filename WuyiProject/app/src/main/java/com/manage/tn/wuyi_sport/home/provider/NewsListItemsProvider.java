package com.manage.tn.wuyi_sport.home.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.NewsInfo;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.TimeUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.MyApplication;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class NewsListItemsProvider extends BaseViewProvider<NewsInfo> {
    public NewsListItemsProvider(@NonNull Context context){
        super(context, R.layout.item_community_list);

    }
    @Override
    public void onBindView(RecyclerViewHolder holder, NewsInfo bean) {
        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getIcoUrlString())
                .apply(options)
                .into(item_image);
        holder.setText(R.id.item_pub, DateUtil.isEmpty(bean.getPublicDate())?"发布于 00-00-00":"发布于 "+bean.getPublicDate().substring(0,10));
        holder.setText(R.id.item_vc,"浏览量 "+bean.getReadNum());
        holder.setText(R.id.item_title,DateUtil.isEmpty(bean.getTitle())?"":bean.getTitle());
        final TextView title = holder.get(R.id.item_title);
        holder.getRootView().setOnClickListener(view -> {

        });

    }
}
