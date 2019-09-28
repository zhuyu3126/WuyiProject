package com.manage.tn.wuyi_sport.club.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class ClubMemberStarAdapter extends SingleTypeAdapter<ClubMember> {

    public ClubMemberStarAdapter(@NonNull Context context) {
        super(context, R.layout.round_studentitem_view);
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, ClubMember bean) {
        holder.setText(R.id.name, DateUtil.isEmpty(bean.getName())?"":bean.getName());
        Button guanzhuBtn=holder.get(R.id.guanZhuBtn);
        guanzhuBtn.setActivated(true);
        ImageView item_image=holder.get(R.id.myimage);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new CircleCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
