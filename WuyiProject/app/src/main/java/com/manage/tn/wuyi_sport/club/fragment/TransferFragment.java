package com.manage.tn.wuyi_sport.club.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonapi.bean.home.club.ClubType;
import com.danmo.commonapi.bean.home.club.CommounItem;
import com.danmo.commonutil.recyclerview.adapter.multitype.HeaderFooterAdapter;
import com.danmo.commonutil.recyclerview.layoutmanager.SpeedyLinearLayoutManager;
import com.manage.tn.wuyi_sport.base.refresh.RefreshRecyclerFragment;
import com.manage.tn.wuyi_sport.club.provider.ClubHeadProvider;
import com.manage.tn.wuyi_sport.club.provider.MiddleClubProvider;
import com.manage.tn.wuyi_sport.club.provider.TransferItemProvider;
import com.manage.tn.wuyi_sport.util.EventBusMsg;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TransferFragment extends RefreshRecyclerFragment {
    int type=0;//数据调用类型 0：队员 1：特保  2：教练
    @Override
    public void initData(HeaderFooterAdapter adapter) {
        setLoadMoreEnable(true);
        loadMiddle();
    }

    @Override
    protected void setAdapterRegister(Context context, RecyclerView recyclerView, HeaderFooterAdapter adapter) {
        adapter.register(CommounItem.class,new TransferItemProvider(getContext()));
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getRecyclerViewLayoutManager() {
        return new SpeedyLinearLayoutManager(getContext());
    }

    @NonNull
    @Override
    protected String request(int offset, int limit) {
        String uuid="";
        if(type==0){
            uuid=CommonApi.homeImple.getClubMemberList("");
        }else if(type==1){
            uuid=CommonApi.homeImple.getBodyguard("");
        }else if(type==2){
            uuid=CommonApi.homeImple.getCoachListByClub("");
        }
        return uuid;
    }

    @NonNull
    @Override
    protected String requestHeader() {
        return null;
    }

    @NonNull
    @Override
    protected String requestMiddle() {
        mAdapter.registerMiddle(new ClubType(2),new MiddleClubProvider(getContext()));
        return null;
    }

    @Override
    protected void onRefresh(BaseResponse event, HeaderFooterAdapter adapter) {
            if(event.getCode()==Constant.SUCCESS){
                adapter.clearDatas();
                if(event.getRows()!=null&&event.getRows().size()>0){
                    adapter.addDatas(event.getRows());
                }
                adapter.notifyDataSetChanged();
            }

    }

    @Override
    protected void onLoadMore(BaseResponse event, HeaderFooterAdapter adapter) {
        if(event.getCode()==Constant.SUCCESS){
            if(event.getRows()!=null&&event.getRows().size()>0){
                adapter.addDatas(event.getRows());
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiverType(EventBusMsg eventBusMsg){
        type=eventBusMsg.getRadiotype();
        refresh(POST_REFRESH);
    }


}
