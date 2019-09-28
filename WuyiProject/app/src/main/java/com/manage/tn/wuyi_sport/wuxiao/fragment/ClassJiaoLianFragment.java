package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.media.MediaPlayer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.CoachItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.adapter.CoachItemAdapter;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildPicListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClassJiaoLianFragment extends BaseFragment {
    ClassItem classItem;
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    private int mPositionWhenPaused = -1;
    private MediaController mMediaController;
    @BindView(R.id.videobtn)
    RadioButton videoBtn;
    @BindView(R.id.imagbtn)
    RadioButton imageBtn;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    @BindView(R.id.signupNum)
    TextView signupNum;//已报名人数
    @BindView(R.id.accommodateNum)
    TextView accommodateNum;//可报名人数
    @BindView(R.id.className)
    TextView className;
    @BindView(R.id.recyclecocah)
    PullToRefreshRecyclerView coachRecycle;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    GrildPicListAdapter adapter;
    List<BannerItem> bannerItems=new ArrayList<>();
    List<BannerItem> currentBanner=new ArrayList<>();
    List<String> images = new ArrayList<String>();
    List<CoachItem> coachItems=new ArrayList<>();
    CoachItemAdapter coachItemAdapter;
    @Override
    protected void lazyLoad() {
        mPostTypes.put(CommonApi.homeImple.selectBannerList(5,"班级","5"),"selectBannerList") ;
        mPostTypes.put(CommonApi.homeImple.selectCoachByClassId(classItem.getClassId()),"selectCoachByClassId") ;
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        classItem= (ClassItem) getArguments().getSerializable("classItem");
        lazyLoad();
        radioType.setVisibility(View.VISIBLE);
        mMediaController = new MediaController(getContext());
        coachRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        coachRecycle.setPullRefreshEnabled(true);
        coachRecycle.setLoadingMoreEnabled(true);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setLinsener();
        if(classItem!=null){
            if(recyclerView.getAdapter()==null){
                adapter=new GrildPicListAdapter(mContext);
                if(!DateUtil.isEmpty(classItem.getClassStyles())){
                    adapter.setDatas(classItem.getClassStyles());
                }
                recyclerView.setAdapter(adapter);
            }else{
                if(!DateUtil.isEmpty(classItem.getClassStyles())){
                    adapter.addDatas(classItem.getClassStyles());
                }
            }
            adapter.notifyDataSetChanged();

        }


    }
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(mPostTypes.get(response.getUuid())!=null){
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    bannerItems= response.getRows();
                    images.clear();
                    currentBanner.clear();
                    for(BannerItem bannerItem:bannerItems){
                        if(bannerItem.getPlayType()==2){
                            images.add(bannerItem.getBannerPicture());
                            currentBanner.add(bannerItem);
                        }
                    }
                    banner.setDataAdapter(images,new BannerViewAdapter());
                }
            }else if(mPostTypes.get(response.getUuid()).equals("selectCoachByClassId")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    if(response.getRows()!=null&&response.getRows().size()>0){
                        coachItems=response.getRows();
                        if(coachRecycle.getAdapter()==null){
                            coachItemAdapter=new CoachItemAdapter(getContext());
                            coachItemAdapter.setDatas(coachItems);
                            coachRecycle.setAdapter(coachItemAdapter);
                        }else{
                            coachItemAdapter.addDatas(coachItems);

                        }
                        coachItemAdapter.notifyDataSetChanged();
                    }

                }
            }


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


        coachRecycle.setPullToRefreshListener(new PullToRefreshListener() {
          @Override
          public void onRefresh() {
              coachRecycle.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      coachRecycle.setRefreshComplete();
                  }
              }, 500);
          }

          @Override
          public void onLoadMore() {
              coachRecycle.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      coachRecycle.setLoadMoreComplete();
                  }
              }, 500);
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
        return R.layout.class_jiaolian_view;
    }
}
