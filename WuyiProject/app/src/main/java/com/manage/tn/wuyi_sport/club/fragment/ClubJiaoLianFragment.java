package com.manage.tn.wuyi_sport.club.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonapi.bean.home.school.CoachItem;
import com.danmo.commonutil.recyclerview.adapter.multitype.HeaderFooterAdapter;
import com.danmo.commonutil.recyclerview.layoutmanager.SpeedyLinearLayoutManager;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.manage.tn.wuyi_sport.base.refresh.RefreshRecyclerFragment;
import com.manage.tn.wuyi_sport.club.provider.ClubCoachItemProvider;
import com.manage.tn.wuyi_sport.club.provider.ClubHeadProvider;
import com.manage.tn.wuyi_sport.wuxiao.provider.CoachHeadProvider;
import com.manage.tn.wuyi_sport.wuxiao.provider.CoachListItemProvider;

import java.util.List;

public class ClubJiaoLianFragment extends RefreshRecyclerFragment {
    public ClubItem clubItem;
    @Override
    public void initData(HeaderFooterAdapter adapter) {
        setLoadMoreEnable(true);

    }

    @Override
    protected void setAdapterRegister(Context context, RecyclerView recyclerView, HeaderFooterAdapter adapter) {
        adapter.register(CoachItem.class,new ClubCoachItemProvider(getContext()));
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getRecyclerViewLayoutManager() {
        return  new SpeedyLinearLayoutManager(getContext());
    }

    @NonNull
    @Override
    protected String request(int offset, int limit) {
        return CommonApi.homeImple.getCoachListByClubId(3,clubItem.getClubId());
    }

    @NonNull
    @Override
    protected String requestHeader() {
        return null;
    }

    @NonNull
    @Override
    protected String requestMiddle() {
        return null;
    }

    @Override
    protected void onRefresh(BaseResponse event, HeaderFooterAdapter adapter) {
        if(event.getCode()==Constant.SUCCESS){
            List<CoachItem> list=event.getRows();
            adapter.clearDatas();
            if(list!=null&&list.size()>0){
                adapter.addDatas(list);
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onLoadMore(BaseResponse event, HeaderFooterAdapter adapter) {
        if(event.getCode()==Constant.SUCCESS){
            List<CoachItem> list=event.getRows();
            if(list!=null&&list.size()>0){
                adapter.addDatas(list);
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onLoadHeader(BaseResponse event, HeaderFooterAdapter adapter) {

    }

    @Override
    protected void onLoadMiddle(BaseResponse event, HeaderFooterAdapter adapter) {

    }

    @Override
    protected void onError(BaseResponse event, String postType) {
        if (postType.equals(POST_LOAD_MORE)) {
            toast("加载更多失败");
        } else if (postType.equals(POST_REFRESH)) {
            toast("刷新数据失败");
        }
    }




}
