package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.VipCardItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.luck.picture.lib.tools.DateUtils;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class VipItemProvider extends BaseViewProvider<VipCardItem> {

    String  clubName="";
    public VipItemProvider(@NonNull Context context,String Clubname) {
        super(context, R.layout.vip_item_view);
        clubName=Clubname;
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, VipCardItem bean) {
        ImageView item_image = holder.get(R.id.image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL + bean.getCardImage())
                .apply(options)
                .into(item_image);
        holder.setText(R.id.club_name,clubName);
        holder.setText(R.id.vip_name, "/"+(DateUtil.isEmpty(bean.getCardName())?"":bean.getCardName()));
        holder.setText(R.id.price, "￥"+bean.getPrice()+" 元起");
        Button buyBtn =holder.get(R.id.buyBtn);
        buyBtn.setActivated(true);
    }
    }
