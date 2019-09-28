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

import java.util.List;

public class RecycleVideoListAdapter extends SingleTypeAdapter<VideoItem> {
    List<VideoItem> videoItemsAll;
    public RecycleVideoListAdapter(@NonNull Context context,List<VideoItem> all) {
        super(context, R.layout.video_item2_view);
        videoItemsAll=all;
    }

    public List<VideoItem> getVideoItemsAll() {
        return videoItemsAll;
    }

    public void setVideoItemsAll(List<VideoItem> videoItemsAll) {
        this.videoItemsAll = videoItemsAll;
    }

    @Override
    public void convert(int position, RecyclerViewHolder holder, VideoItem bean) {

        ImageView item_image=holder.get(R.id.item_image);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhotoUrlString())
                .apply(options)
                .into(item_image);
        holder.setText(R.id.name, DateUtil.isEmpty(bean.getName())?"":bean.getName());
        holder.setText(R.id.channelName,DateUtil.isEmpty(bean.getChannelName())?"":bean.getChannelName());
        holder.setText(R.id.readNum,bean.getReadNum()+"万次浏览");
        holder.getRootView().setOnClickListener(view -> {
            VideoDetialActivity.start((BaseActivity)mContext,bean,videoItemsAll);
        });

    }
}
