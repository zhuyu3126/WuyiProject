package com.manage.tn.wuyi_sport.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.danmo.commonapi.bean.BaseResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T> extends Fragment {
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    protected Context mContext;
    private ViewHolder mViewHolder;
    private View mRoot;
    private Unbinder unbinder;
    public ArrayMap<String, String> mPostTypes = new ArrayMap<String, String>();// 所有请求类型

    /**
     * 标志位，标志已经初始化完成
     */
    public  boolean isPrepared;
    /**
     * Fragment当前状态是否可见
     */
    public boolean isVisible;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
    //先于oncreatview执行的方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    @Override
    public  void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFragmentResult(BaseResponse<T> response){
        httpOnResult(response);
    };
    protected  abstract void httpOnResult(BaseResponse<T> response);//接口成功返回回调

    /**
     * 可见
     */
    protected void onVisible() {
        if (!isPrepared || !getUserVisibleHint()) {
            return;
        }
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    /**
     * 延迟加载数据子Fragment必须重写来加载数据
     */
    protected abstract void lazyLoad();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null!=mRoot){
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);
            unbinder = ButterKnife.bind(this, mViewHolder.getRootView());
        }else{
          mViewHolder=new ViewHolder(inflater,container,getLayoutId());
          mRoot=mViewHolder.getRootView();
          isPrepared=true;
          unbinder= ButterKnife.bind(this,mViewHolder.getRootView());
          initViews(mViewHolder, mViewHolder.getRootView());
      }

        return mViewHolder.getRootView();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mViewHolder.getRootView() != null) {
            ((ViewGroup) mViewHolder.getRootView().getParent()).removeView(mViewHolder.getRootView());
        }
        if(unbinder!=null)
            unbinder.unbind();
    }
    protected void toast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
    protected abstract void initViews(ViewHolder holder, View root);
    protected  abstract int getLayoutId();

}
