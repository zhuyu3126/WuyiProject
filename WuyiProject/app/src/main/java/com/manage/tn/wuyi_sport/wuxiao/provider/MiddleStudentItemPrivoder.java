package com.manage.tn.wuyi_sport.wuxiao.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.bean.home.school.StudentItem;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.wuxiao.adapter.StudentItemAdapter;

public class MiddleStudentItemPrivoder extends BaseViewProvider<StudentItem> {
    StudentItemAdapter adapter;
    Context context;
    private int schoolId;
    public MiddleStudentItemPrivoder(@NonNull Context context,int schoolId) {
        super(context, R.layout.search_recycle);
        this.context=context;
        this.schoolId=schoolId;
    }
    @Override
    public void onBindView(RecyclerViewHolder holder,StudentItem bean) {
        PullToRefreshRecyclerView refreshRecyclerView=holder.get(R.id.recycle);
        refreshRecyclerView.setLayoutManager(new GridLayoutManager(context,3));
        refreshRecyclerView.setPullRefreshEnabled(true);
        refreshRecyclerView.setLoadingMoreEnabled(true);

        adapter.notifyDataSetChanged();
        refreshRecyclerView.setAdapter(adapter);
        refreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                refreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshRecyclerView.setRefreshComplete();
                    }
                },500);
            }

            @Override
            public void onLoadMore() {
                refreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CommonApi.homeImple.getStudentList(schoolId);
                        refreshRecyclerView.setLoadMoreComplete();
                    }
                },500);
            }
        });

    }



}
