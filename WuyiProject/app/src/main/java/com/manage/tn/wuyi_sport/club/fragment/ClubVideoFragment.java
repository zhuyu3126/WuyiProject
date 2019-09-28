package com.manage.tn.wuyi_sport.club.fragment;

import android.media.MediaPlayer;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildVideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCUserActionStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClubVideoFragment extends BaseFragment {
    ClubItem clubItem;
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    @BindView(R.id.videobtn)
    RadioButton videobtn;
    @BindView(R.id.imagbtn)
    RadioButton imagbtn;
    List<BannerItem> bannerItems=new ArrayList<>();
    List<VideoItem> videoItems=new ArrayList<>();
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    GrildVideoListAdapter adapter;
    List<BannerItem> currentBanner=new ArrayList<>();
    List<String> images = new ArrayList<String>();
    @Override
    protected void lazyLoad() {
        clubItem= (ClubItem) getArguments().getSerializable("clubItem");
        mPostTypes.put(CommonApi.homeImple.selectBannerList(3,"视频","3"),"selectBannerList");
        mPostTypes.put(CommonApi.homeImple.getVideoList(5,clubItem.getClubId()),"getVideoList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        radioType.setVisibility(View.VISIBLE);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setListener();
    }
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())){
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    bannerItems=response.getRows();
                    images=new ArrayList<>();
                    currentBanner.clear();
                    for(BannerItem bannerItem:bannerItems){
                        if(bannerItem.getPlayType()==2){
                            currentBanner.add(bannerItem);
                            images.add(bannerItem.getBannerPicture());
                        }
                    }
                    banner.setDataAdapter(images,new BannerViewAdapter());

                }

            }else if(mPostTypes.get(response.getUuid()).equals("getVideoList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    videoItems=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new GrildVideoListAdapter(getContext(),videoItems);
                        adapter.setDatas(videoItems);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(videoItems);
                        adapter.setVideoItemsAll(videoItems);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

        }




    }
    public void setListener(){
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


        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                if(videobtn.isChecked()){
                    videoView.setVisibility(View.VISIBLE);
                    banner.setVisibility(View.INVISIBLE);
                    videoView.setUp(Constant.IMAGE_URL+currentBanner.get(position).getBannerVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
                    videoView.startVideo();
                }

            }
        });
        recyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setRefreshComplete();
                    }
                },500);
            }

            @Override
            public void onLoadMore() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLoadMoreComplete();
                    }
                },500);
            }
        });

    }
    @Override
    protected void onVisible() {
        if(banner!=null&&videoView!=null&&imagbtn!=null&&videobtn!=null){
            banner.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.INVISIBLE);
            imagbtn.setChecked(true);
            videobtn.setChecked(false);
        }
        super.onVisible();
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
        videoView = null;
        super.onDestroy();
    }




    @Override
    protected int getLayoutId() {
        return R.layout.school_video_view;
    }
}
