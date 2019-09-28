package com.manage.tn.wuyi_sport.wuxiao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.wuxiao.activity.ClassActivity;
import com.manage.tn.wuyi_sport.wuxiao.activity.VideoDetialActivity;

import java.math.BigDecimal;

public class GrildClassListAdapter extends SingleTypeAdapter<ClassItem> {

    public GrildClassListAdapter(@NonNull Context context) {
        super(context, R.layout.class_list_view);
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, ClassItem bean) {

        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);
        holder.setText(R.id.price,(  bean.getPrice().setScale( 0, BigDecimal.ROUND_UP ).intValue())+(DateUtil.isEmpty(bean.getUnitPrice())?"":bean.getUnitPrice()));
        holder.getRootView().setOnClickListener(view -> {
            ClassActivity.start((BaseActivity)mContext,bean);
        });

    }
}
