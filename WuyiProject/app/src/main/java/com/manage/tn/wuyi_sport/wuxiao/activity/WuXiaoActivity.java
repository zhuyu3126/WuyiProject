package com.manage.tn.wuyi_sport.wuxiao.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.singletype.SingleTypeAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WuXiaoActivity extends BaseActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    SchoolItemAdapter adapter;
    @Override
    protected void initViews() {
        super.initViews();
        title_text.setText("附近武校");
        toolbar.setNavigationOnClickListener(view -> {finish();});
         loding("加载中...");
        mPostTypes.put(CommonApi.homeImple.selectBannerList(1,"视频","1"),"selectBannerList") ;
        mPostTypes.put(CommonApi.homeImple.getSchoolList("长兴县"),"getSchoolList") ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wuxiao_main;
    }
/*
* 接口回调
* */
    @Override
    protected void httpOnResult(BaseResponse response) {

        if(null!=mPostTypes.get(response.getUuid())){
            finishLoding();
            if(mPostTypes.get(response.getUuid()).equals("selectBannerList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    List<BannerItem> list=response.getRows();
                    List<String> images=new ArrayList<>();
                    for(BannerItem bannerItem:list){
                        if(bannerItem.getPlayType()==2){
                            images.add(bannerItem.getBannerPicture());
                        }

                    }
                    banner.setDataAdapter(images,new BannerViewAdapter());
                    setListener();
                }else{
                    List<String> images=new ArrayList<>();
                    banner.setDataAdapter(images,new BannerViewAdapter());
                }
            }else if(mPostTypes.get(response.getUuid()).equals("getSchoolList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    List<SchoolItem> list=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new SchoolItemAdapter(this);
                        adapter.addDatas(list);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(list);
                        adapter.notifyDataSetChanged();
                    }
                }
            }


        }
    }

    public static void start(Activity activity){
        activity.startActivity(new Intent(activity,WuXiaoActivity.class));
    }
    /*
**监听
* */
    public void setListener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {

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
* 学校Item适配器
* */
    class SchoolItemAdapter extends SingleTypeAdapter<SchoolItem> {
        public SchoolItemAdapter(Context context){
            super(context,R.layout.school_item_view);
        }

        @Override
        public void convert(int position, RecyclerViewHolder holder, SchoolItem bean) {

            ((TextView)holder.get(R.id.school_name)).setText(DateUtil.isEmpty(bean.getName())?"":bean.getName());
            ImageView item_image=holder.get(R.id.item_image);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_placeholder)
                    .transform(new GlideRoundTransform(mContext, 8))
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(mContext)
                    .load(Constant.IMAGE_URL+bean.getPhoto())
                    .apply(options)
                    .into(item_image);
            ((TextView)holder.get(R.id.visitNum)).setText("浏览量 "+bean.getVisitNum());
            Button guanzhubtn=holder.get(R.id.guanZhuBtn);
            if(bean.getFavorStatus()==0){
                guanzhubtn.setActivated(true);
            }else{
                guanzhubtn.setActivated(false);
            }

            holder.getRootView().setOnClickListener(view -> {
                WuXiaoDetialActivity.start(WuXiaoActivity.this,bean);
            });

        }
    }
}
