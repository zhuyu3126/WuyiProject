package com.manage.tn.wuyi_sport.gym.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.gym.CourseItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class GymCourseItemAdapter extends SingleTypeAdapter<CourseItem>{

    public GymCourseItemAdapter(@NonNull Context context) {
        super(context, R.layout.courseitem_list_view);
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, CourseItem bean) {
        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 10))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);
        holder.setText(R.id.name, DateUtil.isEmpty(bean.getCourseName())?"":bean.getCourseName());
        ((RatingBar)holder.get(R.id.ratingbar)).setRating((float) bean.getScoreNum());
        holder.setText(R.id.start_value,bean.getScoreNum()+"分");
        holder.setText(R.id.platformPrice, ""+bean.getPlatformPrice().toBigInteger());
        holder.setText(R.id.retailPrice, "门市价"+bean.getRetailPrice().toBigInteger());
    }
}
