package com.manage.tn.wuyi_sport.club.fragment;

import android.media.MediaPlayer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCUserActionStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClubJianJieFragment extends BaseFragment {
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.videobtn)
    RadioButton videoBtn;
    @BindView(R.id.imagbtn)
    RadioButton imageBtn;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    private int mPositionWhenPaused = -1;
    private MediaController mMediaController;
    List<BannerItem> bannerItems=new ArrayList<>();
    List<BannerItem> currentBanner=new ArrayList<>();
    List<String> images = new ArrayList<String>();
    ClubItem clubItem;
    @BindView(R.id.horizenRecyle)
    RecyclerView recyclerView;
    @BindView(R.id.businessDate)
    TextView businessDate;//营业日期
    @BindView(R.id.businessTime)
    TextView businessTime;//营业时间
    @BindView(R.id.item_vc)
    TextView item_vc;//浏览数
    @BindView(R.id.favorNum)
    TextView favorNum;//点赞数
    @BindView(R.id.focusNum)
    TextView focusNum;//粉丝数
    @BindView(R.id.remark)
    TextView remark;//介绍


    @Override
    protected void lazyLoad() {
        clubItem= (ClubItem) getArguments().getSerializable("clubItem");
        mPostTypes.put(CommonApi.homeImple.selectBannerList(3,"简介","3"),"selectBannerList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        radioType.setVisibility(View.VISIBLE);
        mMediaController = new MediaController(mContext);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        LinearLayoutManager layout=new LinearLayoutManager(mContext);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layout);
        setLinsener();
        if(clubItem!=null){
            businessDate.setText(DateUtil.isEmpty(clubItem.getBusinessDate())?"营业时间:":"营业时间:"+clubItem.getBusinessDate());
            businessTime.setText(DateUtil.isEmpty(clubItem.getBusinessTime())?"":clubItem.getBusinessTime());
            remark.setText(DateUtil.isEmpty(clubItem.getRemark())?"":clubItem.getRemark());
            item_vc.setText("浏览量 "+clubItem.getVisitNum());
            favorNum.setText(clubItem.getFavorNum()+" 万");
            focusNum.setText("粉丝 "+clubItem.getFocusNum()+"万");
            ImageView item_image=holder.get(R.id.item_image);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_placeholder)
                    .transform(new GlideRoundTransform(mContext, 8))
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(mContext)
                    .load(Constant.IMAGE_URL+clubItem.getPhoto())
                    .apply(options)
                    .into(item_image);
        }
    }
    public void  setLinsener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                videoView.setVisibility(View.VISIBLE);
                banner.setVisibility(View.INVISIBLE);
                videoView.setUp(Constant.IMAGE_URL+ currentBanner.get(position).getBannerVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
                videoView.startVideo();
            }
        });
        radioType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                images.clear();
                currentBanner.clear();
                switch (i){
                    case R.id.videobtn:
                        banner.setVisibility(View.VISIBLE);
                        for(BannerItem bannerItem:bannerItems){
                            if(bannerItem.getPlayType()==1){
                                images.add(bannerItem.getBannerPicture());
                                currentBanner.add(bannerItem);
                            }

                        }

                        break;
                    case R.id.imagbtn:
                        banner.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.GONE);
                        for(BannerItem bannerItem:bannerItems){
                            if(bannerItem.getPlayType()==2){
                                images.add(bannerItem.getBannerPicture());
                                currentBanner.add(bannerItem);
                            }

                        }

                        JCVideoPlayer.releaseAllVideos();
                        break;
                }
                banner.setDataAdapter(images,new BannerViewAdapter());
            }
        });




    }
    @Override
    protected void httpOnResult(BaseResponse response) {
        if (mPostTypes.get(response.getUuid()) != null) {
            if (mPostTypes.get(response.getUuid()).equals("selectBannerList")) {
                mPostTypes.remove(response.getUuid());
                if (response.getCode() == Constant.SUCCESS) {
                    bannerItems = response.getRows();
                    images.clear();
                    currentBanner.clear();
                    for (BannerItem bannerItem : bannerItems) {
                        if (bannerItem.getPlayType() == 2) {
                            images.add(bannerItem.getBannerPicture());
                            currentBanner.add(bannerItem);
                        }
                    }
                    banner.setDataAdapter(images, new BannerViewAdapter());
                }
            }
        }
    }

    @Override
    protected void onVisible() {
        super.onVisible();
        if(banner!=null&&videoView!=null&&imageBtn!=null&&videoBtn!=null){
            banner.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.INVISIBLE);
            imageBtn.setChecked(true);
            videoBtn.setChecked(false);
        }
    }

    @Override
    protected void onInvisible() {
        super.onInvisible();
        if(videoView!=null){
            videoView.changeUiToPauseShow();
            JCVideoPlayer.releaseAllVideos();
        }
        super.onPause();
    }
    @Override
    public void onPause() {
        JCVideoPlayer.releaseAllVideos();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mMediaController = null;
        videoView = null;
        super.onDestroy();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.club_jianjie_view;
    }
}
