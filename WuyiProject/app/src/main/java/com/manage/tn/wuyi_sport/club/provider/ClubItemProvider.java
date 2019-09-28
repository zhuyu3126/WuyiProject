package com.manage.tn.wuyi_sport.club.provider;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.club.activity.ClubDetialActivity;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.wuxiao.activity.WuXiaoActivity;
import com.manage.tn.wuyi_sport.wuxiao.activity.WuXiaoDetialActivity;

public class ClubItemProvider extends BaseViewProvider<ClubItem> {


    public ClubItemProvider(@NonNull Context context) {
        super(context, R.layout.school_item_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, ClubItem bean) {

        ((TextView)holder.get(R.id.school_name)).setText(DateUtil.isEmpty(bean.getClubName())?"":bean.getClubName());
        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);
        ((TextView)holder.get(R.id.visitNum)).setText("环境很好，教练更专业");
        Button guanzhubtn=holder.get(R.id.guanZhuBtn);
        if(bean.getFavorStatus()==0){
            guanzhubtn.setActivated(true);
        }else{
            guanzhubtn.setActivated(false);
        }

        holder.getRootView().setOnClickListener(view -> {
            ClubDetialActivity.start((BaseActivity) mContext,bean);
        });

    }
}
