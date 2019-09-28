package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonapi.bean.home.school.StudentItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.StudentItemAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class DuiYuanFragment extends BaseFragment {
    public SchoolItem schoolItem;
    public ClassItem classItem;
    private int mPositionWhenPaused = -1;
    private MediaController mMediaController;
    @BindView(R.id.banner)
    BannerWrapperView banner;
    @BindView(R.id.videobtn)
    RadioButton videoBtn;
    @BindView(R.id.imagbtn)
    RadioButton imageBtn;
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    @BindView(R.id.guanZhuBtn)
    Button guanzhuBtn;
    @BindView(R.id.banner_title)
    TextView banner_title;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    @BindView(R.id.banner_text_view)
    LinearLayout banner_text_view;
    StudentItemAdapter adapter;
    List<String> images = new ArrayList<String>();
    List<BannerItem> datas=new ArrayList<>();
    List<BannerItem> currentBanner=new ArrayList<>();
    List<StudentItem> studentItems=new ArrayList<>();
    int type;//0代表学校 1代表班级

    @Override
    protected void lazyLoad() {
        type=getArguments().getInt("type");
        if(type==0){
            schoolItem= (SchoolItem) getArguments().getSerializable("schoolItem");
            mPostTypes.put(CommonApi.homeImple.selectBannerList(1,"队员","1"),"selectBannerList");
            mPostTypes.put( CommonApi.homeImple.getStudentList(schoolItem.getSchoolId()),"getStudentList");
        }else if(type==1){
            classItem= (ClassItem) getArguments().getSerializable("classItem");
            mPostTypes.put(CommonApi.homeImple.selectBannerList(5,"队员","5"),"selectBannerList");
            mPostTypes.put( CommonApi.homeImple.getClassStudentList(classItem.getClassId()),"getClassStudentList");
        }


    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        banner_title.setText("精英争霸赛来啦！2018年精英争霸赛报名开启...");
        mMediaController = new MediaController(getContext());
        guanzhuBtn.setActivated(true);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        radioType.setVisibility(View.VISIBLE);
        banner_text_view.setVisibility(View.VISIBLE);
        imageBtn.setChecked(true);
        videoBtn.setChecked(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setLinsener();
    }


    public void setLinsener(){
        radioType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                images.clear();
                currentBanner.clear();
                switch (i){
                    case R.id.videobtn:
                        banner.setVisibility(View.VISIBLE);
                        for(BannerItem bannerItem:datas){
                            if(bannerItem.getPlayType()==1){
                                currentBanner.add(bannerItem);
                                images.add(bannerItem.getBannerPicture());
                            }

                        }

                        break;
                    case R.id.imagbtn:
                        banner.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.INVISIBLE);
                        for(BannerItem bannerItem:datas){
                            if(bannerItem.getPlayType()==2){
                                currentBanner.add(bannerItem);
                                images.add(bannerItem.getBannerPicture());
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
                    banner.setVisibility(View.INVISIBLE);
                    videoView.setUp(Constant.IMAGE_URL+currentBanner.get(position).getBannerVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL);
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
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())){
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    if(response.getRows()!=null&&response.getRows().size()>0){
                       datas=response.getRows();
                        images.clear();
                        currentBanner.clear();
                        for(BannerItem bannerItem:datas){
                            if(bannerItem.getPlayType()==2){
                                currentBanner.add(bannerItem);
                                images.add(bannerItem.getBannerPicture());
                            }
                        }
                        banner.setDataAdapter(images,new BannerViewAdapter());
                    }
                }
            }else if(mPostTypes.get(response.getUuid()).equals("getStudentList")||mPostTypes.get(response.getUuid()).equals("getClassStudentList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()==Constant.SUCCESS){
                    if(response.getRows()!=null&&response.getRows().size()>0){
                        studentItems=response.getRows();
                        if(recyclerView.getAdapter()==null){
                            adapter=new StudentItemAdapter(getContext());
                            adapter.setDatas(studentItems);
                        }else{
                            adapter.addDatas(studentItems);
                        }
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
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
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroy() {
        mMediaController = null;
        videoView = null;
        super.onDestroy();
    }



    @Override
    protected int getLayoutId() {
        return R.layout.duiyuan_view;
    }
}
