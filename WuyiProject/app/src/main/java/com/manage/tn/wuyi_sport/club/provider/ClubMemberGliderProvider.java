package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class ClubMemberGliderProvider extends BaseViewProvider<ClubMember> {

    public ClubMemberGliderProvider(@NonNull Context context) {
        super(context, R.layout.studentitem_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, ClubMember bean) {
        LinearLayout descrebe_layout=holder.get(R.id.descrob_layout);
        TextView guanzhuBtn=holder.get(R.id.guanzhuBtn);
        descrebe_layout.setVisibility(View.VISIBLE);
        ImageView item_image=holder.get(R.id.image_view);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);

        holder.setText(R.id.name, DateUtil.isEmpty(bean.getName())?"":bean.getName());
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
