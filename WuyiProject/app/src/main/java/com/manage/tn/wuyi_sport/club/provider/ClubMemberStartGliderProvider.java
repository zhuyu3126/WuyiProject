package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.danmo.commonapi.bean.home.MiddleItem;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.club.adapter.ClubMemberStarAdapter;

import java.util.List;

public class ClubMemberStartGliderProvider extends BaseViewProvider<MiddleItem> {
    ClubMemberStarAdapter adapter;
    public ClubMemberStartGliderProvider(@NonNull Context context) {
        super(context, R.layout.horzern_reecycle_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, MiddleItem bean) {
        RecyclerView recyclerView=holder.get(R.id.horizenRecyle);
        LinearLayoutManager layout=new LinearLayoutManager(mContext);
        layout.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layout);
        if( recyclerView.getAdapter()==null||adapter==null){
            adapter=new ClubMemberStarAdapter(mContext);
            adapter.setDatas(bean.getData());
            recyclerView.setAdapter(adapter);
        }else {
            adapter.addDatas(bean.getData());
        }
        adapter.notifyDataSetChanged();


    }

}
