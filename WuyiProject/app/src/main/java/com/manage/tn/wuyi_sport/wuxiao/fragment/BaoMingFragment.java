package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonutil.recyclerview.adapter.multitype.HeaderFooterAdapter;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.base.refresh.RefreshRecyclerFragment;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.EventBusMsg;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildClassListAdapter;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildVideoListAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BaoMingFragment extends BaseFragment {
    public SchoolItem schoolItem;
    @BindView(R.id.search_linearlayout)
    LinearLayout search_linearlayout;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    List<ClassItem> classItems=new ArrayList<>();
    GrildClassListAdapter adapter;
    @Override
    protected void lazyLoad() {

        schoolItem= (SchoolItem) getArguments().getSerializable("schoolItem");
        mPostTypes.put(CommonApi.homeImple.getClassList(schoolItem.getSchoolId()),"getClassList");
    }

    @OnClick({R.id.class_btn,R.id.jianjie_btn,R.id.jiaolian_btn})
    public void searhOnclick(View v){
        EventBusMsg eventBusMsg=new EventBusMsg();
        switch (v.getId()){
            case R.id.class_btn:
                search_linearlayout.setVisibility(View.VISIBLE);
                break;
            case R.id.jianjie_btn:
                eventBusMsg.setRadiotype(0);
                EventBus.getDefault().post(eventBusMsg);
                break;
            case R.id.jiaolian_btn:
                eventBusMsg.setRadiotype(1);
                EventBus.getDefault().post(eventBusMsg);
                break;

        }

    }
    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        search_linearlayout.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        setListener();
    }
    public void setListener(){

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
            if(mPostTypes.get(response.getUuid()).equals("getClassList")){
                mPostTypes.remove(response.getUuid());
                if(response.getCode()== Constant.SUCCESS){
                    classItems=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new GrildClassListAdapter(getContext());
                        adapter.setDatas(classItems);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(classItems);
                    }
                    adapter.notifyDataSetChanged();
                }

            }

        }

    }


    @Override
    protected int getLayoutId() {
        return R.layout.baoming_view;
    }
}
