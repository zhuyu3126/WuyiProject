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
import com.danmo.commonapi.bean.home.gym.GymItem;
import com.danmo.commonapi.bean.home.school.CoachItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.adapter.CoachItemAdapter;
import com.manage.tn.wuyi_sport.gym.adapter.GymCoachItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GymJiaoLianFragment extends BaseFragment {
    GymItem gymItem;
    @BindView(R.id.recycle)
    PullToRefreshRecyclerView recyclerView;
    List<CoachItem> coachItems=new ArrayList<>();//当前教练集合
    GymCoachItemAdapter adapter;
    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())&&mPostTypes.get(response.getUuid()).equals("getCoachList")){
            mPostTypes.remove(response.getUuid());
            if(response.getCode()== Constant.SUCCESS){
                if(response.getRows()!=null&&response.getRows().size()>0){
                    coachItems=response.getRows();
                    if(recyclerView.getAdapter()==null){
                        adapter=new GymCoachItemAdapter(getContext());
                        adapter.setDatas(coachItems);
                        recyclerView.setAdapter(adapter);
                    }else{
                        adapter.addDatas(coachItems);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    protected void lazyLoad() {
        gymItem=(GymItem)getArguments().getSerializable("gymItem");
        mPostTypes.put(CommonApi.homeImple.getCoachList(2,gymItem.getGymId()),"getCoachList");
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        FragmentTransaction transaction = ((BaseActivity)mContext).getSupportFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=2;
        headFragment.channelName="私教";
        headFragment.recordId=gymItem.getGymId()+"";
        transaction.add(R.id.j_headView,headFragment,"HeadFragment");
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
        return R.layout.gym_jiaolian_view;
    }
}
