package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCUserActionStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClubHeadProvider extends BaseViewProvider<List<BannerItem>> {
    JCVideoPlayerStandard videoView;
    BannerWrapperView banner;
    RadioButton videoBtn;
    RadioButton imageBtn;
    LinearLayout banner_text_view;
    RadioGroup radioType;
    List<BannerItem> currentBanners=new ArrayList<>();
    public ClubHeadProvider(@NonNull Context context) {
        super(context, R.layout.newest_banner_and_video);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, List<BannerItem> bean) {
         banner=holder.get(R.id.banner);
         videoBtn=holder.get(R.id.videobtn);
         imageBtn=holder.get(R.id.imagbtn);
         videoView=holder.get(R.id.videoView);
         radioType=holder.get(R.id.radioType);
        radioType.setVisibility(View.VISIBLE);
         banner_text_view=holder.get(R.id.banner_text_view);
        banner_text_view.setVisibility(View.GONE);
        Button guanzhuBtn=holder.get(R.id.guanZhuBtn);
        guanzhuBtn.setActivated(true);
        List<String> images = new ArrayList<String>();
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);
        imageBtn.setChecked(true);
        videoBtn.setChecked(false);
        currentBanners.clear();
        for(BannerItem bannerItem:bean){
            if(bannerItem.getPlayType()==2){
                images.add(bannerItem.getBannerPicture());
                currentBanners.add(bannerItem);
            }
        }
        banner.setDataAdapter(images,new BannerViewAdapter());
        radioType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                images.clear();
                currentBanners.clear();
                switch (i){
                    case R.id.videobtn:
                        banner.setVisibility(View.VISIBLE);

                        for(BannerItem bannerItem:bean){
                            if(bannerItem.getPlayType()==1){
                                images.add(bannerItem.getBannerPicture());
                                currentBanners.add(bannerItem);
                            }
                        }

                        break;
                    case R.id.imagbtn:
                        banner.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.GONE);
                        for(BannerItem bannerItem:bean){
                            if(bannerItem.getPlayType()==2){
                                images.add(bannerItem.getBannerPicture());
                                currentBanners.add(bannerItem);
                            }
                        }
                        JCVideoPlayer.releaseAllVideos();
                        break;
                }
                banner.setDataAdapter(images,new BannerViewAdapter());
            }
        });


        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                if(videoBtn.isChecked()){
                    videoView.setVisibility(View.VISIBLE);
                    banner.setVisibility(View.GONE);
                    videoView.setUp(Constant.IMAGE_URL+currentBanners.get(position).getBannerVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
                    videoView.startVideo();
                }

            }
        });


    }

    public void onVisible(){
        if(videoView!=null&&banner!=null){
            videoView.setVisibility(View.INVISIBLE);
            banner.setVisibility(View.VISIBLE);
            imageBtn.setChecked(true);
            videoBtn.setChecked(false);
        }

    }
    /*
     * 暂停视频
     * */

    public void onPoause(){
        if(videoView!=null){
            JCVideoPlayer.releaseAllVideos();
        }

    }
    /*
     * 销毁视频
     * */
    public void onDestroy(){
        videoView = null;
    }

}
