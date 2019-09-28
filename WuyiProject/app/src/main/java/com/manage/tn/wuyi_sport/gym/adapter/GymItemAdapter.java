package com.manage.tn.wuyi_sport.gym.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.gym.GymItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.gym.activity.GymDetialActivity;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
public class GymItemAdapter extends SingleTypeAdapter<GymItem> {
    public GymItemAdapter(@NonNull Context context) {
        super(context, R.layout.school_item_view);
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, GymItem bean) {
        ((TextView)holder.get(R.id.school_name)).setText(DateUtil.isEmpty(bean.getName())?"":bean.getName());
        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);
        ((TextView)holder.get(R.id.visitNum)).setText("环境很，好教练更专业");
        Button guanzhubtn=holder.get(R.id.guanZhuBtn);
        if(bean.getFavorStatus()==0){
            guanzhubtn.setActivated(true);
        }else{
            guanzhubtn.setActivated(false);
        }

        holder.getRootView().setOnClickListener(view -> {
            GymDetialActivity.start((BaseActivity) mContext,bean);
        });
    }
}
