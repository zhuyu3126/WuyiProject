package com.manage.tn.wuyi_sport.gym.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.gym.CourseItem;
import com.danmo.commonapi.bean.home.gym.GymItem;
import com.danmo.commonapi.bean.home.school.VideoItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.gym.adapter.GymCourseItemAdapter;
import com.manage.tn.wuyi_sport.wuxiao.adapter.GrildVideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GymKeChengFragment extends BaseFragment {
    GymItem gymItem;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    List<CourseItem>  courseItems=new ArrayList<>();//
    GymCourseItemAdapter adapter;
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())&&mPostTypes.get(response.getUuid()).equals("getGymCourseItemList")){
            mPostTypes.remove(response.getUuid());
            if(response.getCode()== Constant.SUCCESS){
                courseItems=response.getRows();
                if(recyclerView.getAdapter()==null){
                    adapter=new GymCourseItemAdapter(getContext());
                    adapter.setDatas(courseItems);
                    recyclerView.setAdapter(adapter);
                }else{
                    adapter.addDatas(courseItems);
                }
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void lazyLoad() {
        gymItem=(GymItem)getArguments().getSerializable("gymItem");
        mPostTypes.put(CommonApi.homeImple.getGymCourseItemList(2,gymItem.getGymId()),"getGymCourseItemList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        FragmentTransaction transaction = ((BaseActivity)mContext).getSupportFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=2;
        headFragment.channelName="课程";
        headFragment.recordId=gymItem.getGymId()+"";
        transaction.add(R.id.c_headView,headFragment,"HeadFragment");
        transaction.commitAllowingStateLoss();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
    protected int getLayoutId() {
        return R.layout.gym_course_view;
    }
}
