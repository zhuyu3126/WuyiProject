package com.manage.tn.wuyi_sport.wuxiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
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
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.danmo.commonutil.DateUtil;
import com.lxj.xpopup.XPopup;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.ShardBottomPopupView;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildVideoListAdapter;
import com.manage.tn.wuyi_sport.wuxiao.adapter.RecycleVideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoDetialActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.banner_text_view)
    LinearLayout banner_text_view;
    @BindView(R.id.shardLinearlayout)
    LinearLayout shardLinearlayout;
    @BindView(R.id.favorNum)
    TextView favorNum;//点赞数
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.banner_title)
    TextView banner_title;
    @BindView(R.id.guanZhuBtn)
    TextView guanZhuBtn;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    RecycleVideoListAdapter adapter;
    static  VideoItem videoItem;//视频对象
    static   List<VideoItem> videoItems=new ArrayList<>();//所有视频
    @Override
    protected void initViews() {
        super.initViews();
        toolbar.setNavigationOnClickListener(view -> {finish();});
        banner_text_view.setVisibility(View.VISIBLE);
        shardLinearlayout.setVisibility(View.VISIBLE);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        guanZhuBtn.setActivated(true);
        setLinsener();
        if(videoItem!=null){
            title_text.setText(DateUtil.isEmpty(videoItem.getName())?"":videoItem.getName());
            favorNum.setText(videoItem.getFavorNum()+"");
            banner_title.setText(DateUtil.isEmpty(videoItem.getName())?"":videoItem.getName());
            List<String> images = new ArrayList<String>();
            images.add(videoItem.getPhotoUrlString());
            banner.setDataAdapter(images,new BannerViewAdapter());
            if(recyclerView.getAdapter()==null){
                adapter=new RecycleVideoListAdapter(this,videoItems);
                adapter.setDatas(videoItems);
                recyclerView.setAdapter(adapter);
            }else{
                adapter.addDatas(videoItems);
                adapter.setVideoItemsAll(videoItems);
            }
            adapter.notifyDataSetChanged();
        }

    }

    @OnClick({R.id.wx_shard,R.id.pyq_shard,R.id.favorNum})
    public  void  shardOnclick(View  v){
        XPopup.get(this).autoDismiss(true).asCustom(new ShardBottomPopupView(this)).show();
        switch (v.getId()){
            case R.id.wx_shard:
                break;
            case R.id.pyq_shard:
                break;
            case R.id.favorNum:
                break;


        }

    }

    public void  setLinsener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                videoView.setVisibility(View.VISIBLE);
                banner.setVisibility(View.INVISIBLE);
                videoView.setUp(Constant.IMAGE_URL+videoItem.getVideoUrlString(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
                videoView.startVideo();
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


    public static void start(Activity activity,VideoItem v,List<VideoItem> all){
        activity.startActivity(new Intent(activity,VideoDetialActivity.class));
        videoItem=v;
        videoItems= all;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.video_detial_view;
    }
}
