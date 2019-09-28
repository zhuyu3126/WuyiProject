package com.manage.tn.wuyi_sport.wuxiao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.wuxiao.activity.VideoDetialActivity;

public class GrildPicListAdapter extends SingleTypeAdapter<String> {

    public GrildPicListAdapter(@NonNull Context context) {
        super(context, R.layout.pic_list_view);
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, String bean) {

        ImageView item_image=holder.get(R.id.videoPic);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean)
                .apply(options)
                .into(item_image);

        holder.getRootView().setOnClickListener(view -> {

        });

    }
}
