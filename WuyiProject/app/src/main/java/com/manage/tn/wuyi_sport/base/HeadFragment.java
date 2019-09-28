package com.manage.tn.wuyi_sport.base;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.club.adapter.CoachItemAdapter;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
/*
* 页面头部广告视频
* */
public class HeadFragment extends BaseFragment {
    public int channelType;//类型
    public String channelName;//名称
    public String recordId;//ID号
    public int showTyp;//0默认只显示图片和视频 1：显示图片视频按钮 2显示标题和关注按钮 3 :显示分享界面 4显示上传界面
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    BannerWrapperView banner;
    @BindView(R.id.videobtn)
    RadioButton videoBtn;
    @BindView(R.id.imagbtn)
    RadioButton imageBtn;
    @BindView(R.id.banner_text_view)
    LinearLayout banner_text_view;
    @BindView(R.id.shardLinearlayout)
    LinearLayout shardLinearlayout;
    @BindView(R.id.operatorLinearlayout)
    LinearLayout operatorLinearlayout;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    @BindView(R.id.guanZhuBtn)
    Button guanzhuBtn;

    List<BannerItem> bannerItems=new ArrayList<>();//获取总bannner
    List<BannerItem> currentBanners=new ArrayList<>();//根据类型选择的banner
    List<String> images = new ArrayList<String>();
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())){
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    if(response.getRows()!=null&&response.getRows().size()>0){
                        bannerItems=response.getRows();
                        images.clear();
                        currentBanners.clear();
                        for(BannerItem bannerItem:bannerItems){
                            if(bannerItem.getPlayType()==2){
                                currentBanners.add(bannerItem);
                                images.add(bannerItem.getBannerPicture());
                            }
                        }
                        banner.setDataAdapter(images,new BannerViewAdapter());
                    }
                }
            }

        }
    }
    @Override
    protected void lazyLoad() {
        mPostTypes.put(CommonApi.homeImple.selectBannerList(channelType,channelName,recordId),"selectBannerList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        if(showTyp==0){
            radioType.setVisibility(View.GONE);
            banner_text_view.setVisibility(View.GONE);
            shardLinearlayout.setVisibility(View.GONE);
            operatorLinearlayout.setVisibility(View.GONE);
        }else if(showTyp==1){
            radioType.setVisibility(View.VISIBLE);
        }else if(showTyp==2){
            radioType.setVisibility(View.VISIBLE);
            banner_text_view.setVisibility(View.VISIBLE);
        }else if(showTyp==3){
            banner_text_view.setVisibility(View.VISIBLE);
            shardLinearlayout.setVisibility(View.VISIBLE);
        }else if(showTyp==4){
            operatorLinearlayout.setVisibility(View.VISIBLE);
            banner_text_view.setVisibility(View.VISIBLE);
            guanzhuBtn.setVisibility(View.GONE);
        }
        guanzhuBtn.setActivated(true);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);
        imageBtn.setChecked(true);
        videoBtn.setChecked(false);
        setLinsener();
    }

    public void setLinsener(){
        radioType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                images.clear();
                currentBanners.clear();
                switch (i){
                    case R.id.videobtn:
                        banner.setVisibility(View.VISIBLE);
                        for(BannerItem bannerItem:bannerItems){
                            if(bannerItem.getPlayType()==1){
                                images.add(bannerItem.getBannerPicture());
                                currentBanners.add(bannerItem);
                            }
                        }

                        break;
                    case R.id.imagbtn:
                        banner.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.GONE);
                        for(BannerItem bannerItem:bannerItems){
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

    @Override
    protected void onInvisible() {
        if(videoView!=null){
            videoView.changeUiToPauseShow();
            JCVideoPlayer.releaseAllVideos();
        }
        super.onInvisible();
    }

    public void onVisible(){
        if(banner!=null&&videoView!=null&&imageBtn!=null&&videoBtn!=null){
            banner.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.INVISIBLE);
            imageBtn.setChecked(true);
            videoBtn.setChecked(false);
        }

    }
    /*
     * 暂停视频
     * */

    @Override
    public void onPause() {
        if(videoView!=null){
            JCVideoPlayer.releaseAllVideos();
        }
        super.onPause();
    }

    /*
     * 销毁视频
     * */
    public void onDestroy(){
        videoView = null;
        super.onDestroy();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.newest_banner_and_video;
    }
}
