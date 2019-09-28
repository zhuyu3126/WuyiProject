package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.media.MediaPlayer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildPicListAdapter;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildVideoListAdapter;
import com.manage.tn.wuyi_sport.wuxiao.adapter.RecycleVideoListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClassMainFragment extends BaseFragment {
    ClassItem classItem;
    @BindView(R.id.videoView)
    JCVideoPlayerStandard videoView;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    private int mPositionWhenPaused = -1;
    private MediaController mMediaController;
    @BindView(R.id.class_name)
    TextView class_name;
    @BindView(R.id.payBtn)
    Button payBtn;
    @BindView(R.id.signupNum)
    TextView signupNum;//已报名人数
    @BindView(R.id.accommodateNum)
    TextView accommodateNum;//可报名人数
    @BindView(R.id.remark)
    TextView remark;
    @BindView(R.id.visitNum)
    TextView visitNum;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    GrildPicListAdapter adapter;

    @Override
    protected void httpOnResult(BaseResponse response) {

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        classItem= (ClassItem) getArguments().getSerializable("classItem");
        mMediaController = new MediaController(mContext);
        banner.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setLinsener();
        if(classItem!=null){
            class_name.setText(DateUtil.isEmpty(classItem.getName())?"":classItem.getName());
            visitNum.setText("浏览量 "+classItem.getVisitNum());
            remark.setText(DateUtil.isEmpty(classItem.getRemark())?"":classItem.getRemark());
            signupNum.setText(classItem.getSignupNum()+"人");
            accommodateNum.setText(classItem.getAccommodateNum()+"人");
            payBtn.setActivated(true);
            List<String> images = new ArrayList<String>();
            images.add(classItem.getVideoPhoto());
            banner.setDataAdapter(images,new BannerViewAdapter());
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
    public void  setLinsener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {
                videoView.setVisibility(View.VISIBLE);
                banner.setVisibility(View.INVISIBLE);
                videoView.setUp(Constant.IMAGE_URL+classItem.getVideo(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
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
        return R.layout.class_main_view;
    }
}
