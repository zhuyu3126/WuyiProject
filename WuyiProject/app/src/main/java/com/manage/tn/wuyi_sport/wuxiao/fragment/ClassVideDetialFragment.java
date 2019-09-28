package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.media.MediaPlayer;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.RecycleVideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClassVideDetialFragment extends BaseFragment {
    @BindView(R.id.banner_text_view)
    LinearLayout banner_text_view;
    @BindView(R.id.shardLinearlayout)
    LinearLayout shardLinearlayout;
    @BindView(R.id.favorNum)
    TextView favorNum;//点赞数
    static VideoItem videoItem;//视频对象
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.banner_title)
    TextView banner_title;
    @BindView(R.id.guanZhuBtn)
    TextView guanZhuBtn;
    private int mPositionWhenPaused = -1;
    private MediaController mMediaController;
    List<String> images = new ArrayList<String>();
    List<VideoItem> videoItems=new ArrayList<>();
    List<BannerItem> datas=new ArrayList<>();
    List<BannerItem> currentBanner=new ArrayList<>();
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    RecycleVideoListAdapter adapter;
    @Override
    protected void lazyLoad() {
        mPostTypes.put(CommonApi.homeImple.selectBannerList(5,"班级","5"),"selectBannerList") ;
        mPostTypes.put(CommonApi.homeImple.getVideoList(4,4),"getVideoList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        banner_text_view.setVisibility(View.VISIBLE);
        shardLinearlayout.setVisibility(View.VISIBLE);
        mMediaController = new MediaController(getContext());
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        guanZhuBtn.setActivated(true);
        setLinsener();
    }

    public void  setLinsener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                if(!DateUtil.isEmpty(datas.get(position).getBannerVideo())){
                    if((datas.get(position)).getPlayType()==1){
                        videoView.setVisibility(View.VISIBLE);
                        banner.setVisibility(View.INVISIBLE);
                        videoView.setUp(Constant.IMAGE_URL+currentBanner.get(position).getBannerVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
                        videoView.startVideo();
                    }
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
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())){
            if(mPostTypes.get(response.getUuid()).equals("getVideoList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    videoItems=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new RecycleVideoListAdapter(getContext(),videoItems);
                        adapter.setDatas(videoItems);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(videoItems);
                        adapter.setVideoItemsAll(videoItems);
                    }
                    adapter.notifyDataSetChanged();
                }
            }else   if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    if(response.getRows()!=null&&response.getRows().size()>0){
                        datas=response.getRows();
                        images.clear();
                        currentBanner.clear();
                        for(BannerItem bannerItem:datas){
                            if(bannerItem.getPlayType()==1){
                                currentBanner.add(bannerItem);
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
    protected void onVisible() {
        super.onVisible();
        if(videoView!=null&&banner!=null){
            videoView.setVisibility(View.INVISIBLE);
            banner.setVisibility(View.VISIBLE);
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
        return R.layout.class_video_detial_view;
    }
}
