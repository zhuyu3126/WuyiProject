package com.manage.tn.wuyi_sport.home.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.NewsInfo;
import com.danmo.commonutil.recyclerview.adapter.multitype.HeaderFooterAdapter;
import com.danmo.commonutil.recyclerview.layoutmanager.SpeedyLinearLayoutManager;
import com.manage.tn.wuyi_sport.base.refresh.RefreshRecyclerFragment;
import com.manage.tn.wuyi_sport.home.provider.NewsListItemsProvider;

import java.util.List;

public class HomeContentFragment extends RefreshRecyclerFragment {
    @Override
    public void initData(HeaderFooterAdapter adapter) {
        setLoadMoreEnable(true);

    }
    @NonNull
    @Override
    protected String requestHeader() {
        return null;
    }


    @NonNull
    @Override
    protected String requestMiddle() {
       // mAdapter.registerMiddle(new MiddleItem(),new MiddleStudentItemPrivoder(getContext()));
        return null;
    }



    @NonNull
    @Override
    protected RecyclerView.LayoutManager getRecyclerViewLayoutManager() {
        return new SpeedyLinearLayoutManager(getContext());
    }

    @NonNull
    @Override
    protected String request(int offset, int limit) {
        return CommonApi.homeImple.getNewList("");
    }
    @Override
    protected void setAdapterRegister(Context context, RecyclerView recyclerView, HeaderFooterAdapter adapter) {
        adapter.register(NewsInfo.class,new NewsListItemsProvider(getContext()));
    }

    @Override
    protected void onRefresh(BaseResponse event, HeaderFooterAdapter adapter) {
            if(event.getCode()==Constant.SUCCESS){
                List<NewsInfo> list=event.getRows();
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
            List<NewsInfo> list=event.getRows();
            if(list!=null&&list.size()>0){
                adapter.addDatas(list);
                adapter.notifyDataSetChanged();
            }
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
