package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.EventItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class EventItemProvider extends BaseViewProvider<EventItem> {

    public EventItemProvider(@NonNull Context context) {
        super(context, R.layout.text_item_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, EventItem bean) {
        ImageView  item_image=holder.get(R.id.image);
        ((TextView)holder.get(R.id.name)).setText(DateUtil.isEmpty(bean.getMatchName())?"":bean.getMatchName());
        ((TextView)holder.get(R.id.level)).setText(DateUtil.isEmpty(bean.getMatchLevel())?"":"("+bean.getMatchLevel()+")");
        ((TextView)holder.get(R.id.content)).setText("赛事时间 "+(DateUtil.isEmpty(bean.getStartTime())?"":bean.getStartTime().substring(0,10)));
        ((TextView)holder.get(R.id.describe)).setText("发布时间 "+(DateUtil.isEmpty(bean.getPublishTime())?"":bean.getPublishTime().substring(0,10)));
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPicture())
                .apply(options)
                .into(item_image);

        holder.getRootView().setOnClickListener(view -> {

        });
    }
}
