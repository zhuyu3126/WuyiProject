package com.manage.tn.wuyi_sport.home.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;

import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerPagerAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;


import java.util.ArrayList;
import java.util.List;

public class BannerHeadProvider extends BaseViewProvider<List<BannerItem>> {
    public BannerHeadProvider(@NonNull Context context){
        super(context, R.layout.item_fragment_newest_banner);
    }
    @Override
    public void onBindView(RecyclerViewHolder holder, List<BannerItem> bean) {
             List<String> images = new ArrayList<String>();
             for(BannerItem bannerItem:bean){
                 images.add(bannerItem.getBannerPicture());
             }

        BannerWrapperView banner=holder.get(R.id.banner);
        banner.setDataAdapter(images,new BannerViewAdapter());
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {

            }
        });
    }


}
