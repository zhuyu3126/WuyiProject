package com.manage.tn.wuyi_sport.gym.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.gym.GymItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.gym.adapter.GymItemAdapter;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.widget.edittext.AutoCheckEditText;
import com.manage.tn.wuyi_sport.wuxiao.activity.WuXiaoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class GymMainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.search_context)
    AutoCheckEditText search_context;
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    BannerWrapperView banner;
    @BindView(R.id.videobtn)
    RadioButton videoBtn;
    @BindView(R.id.imagbtn)
    RadioButton imageBtn;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    GymItemAdapter adapter;
    List<BannerItem> bannerItems=new ArrayList<>();//获取总bannner
    List<BannerItem> currentBanners=new ArrayList<>();//根据类型选择的banner
    List<String> images = new ArrayList<String>();
    List<GymItem> gymItems=new ArrayList<>();//当前健身房列表
    @Override
    protected void initViews() {
        super.initViews();
        title_text.setText("附近健身房");
        toolbar.setNavigationOnClickListener(view -> {finish();});
        loding("加载中...");
        radioType.setVisibility(View.VISIBLE);
        mPostTypes.put(CommonApi.homeImple.selectBannerList(6,"健身房",""),"selectBannerList") ;
        mPostTypes.put(CommonApi.homeImple.getGymList("长兴县"),"getGymList") ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);
        imageBtn.setChecked(true);
        videoBtn.setChecked(false);
        setLinsener();

    }

    public static void start(Activity activity){
        activity.startActivity(new Intent(activity,GymMainActivity.class));
    }
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())){
            finishLoding();
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    bannerItems=response.getRows();
                    images=new ArrayList<>();
                    for(BannerItem bannerItem:bannerItems){
                        if(bannerItem.getPlayType()==2){
                            images.add(bannerItem.getBannerPicture());
                        }

                    }
                    banner.setDataAdapter(images,new BannerViewAdapter());

                }else{
                     images=new ArrayList<>();
                    banner.setDataAdapter(images,new BannerViewAdapter());
                }
            }else if(mPostTypes.get(response.getUuid()).equals("getGymList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    gymItems=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new GymItemAdapter(this);
                        adapter.addDatas(gymItems);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(gymItems);
                        adapter.notifyDataSetChanged();
                    }
                }
            }


        }


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
        return R.layout.gym_main_view;
    }

}
