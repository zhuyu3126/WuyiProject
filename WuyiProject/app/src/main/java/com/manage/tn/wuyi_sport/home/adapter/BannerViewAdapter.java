package com.manage.tn.wuyi_sport.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.home.provider.BannerHeadProvider;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerPagerAdapter;

public class BannerViewAdapter extends BannerPagerAdapter<String> {
    @Override
    public BaseBannerViewHolder createViewHolder(ViewGroup container) {
        return new BannerViewHolder();
    }
    public class BannerViewHolder implements BannerPagerAdapter.BaseBannerViewHolder<String>{
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_banner_item_view, null);
            imageView = view.findViewById(R.id.ivBanner);
            return view;
        }

        @Override
        public void bind(Context context, String data, int position) {
            RequestOptions options = new RequestOptions()
                    .transform(new GlideRoundTransform(context, 2))
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(context)
                    .load(Constant.IMAGE_URL+data)
                    .apply(options)
                    .into(imageView);

        }
    }
}
