package com.manage.tn.wuyi_sport.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.danmo.commonapi.base.BaseEvent;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonutil.leak.IMMLeaks;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.manage.tn.wuyi_sport.MainActivity;
import com.manage.tn.wuyi_sport.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public abstract class BaseActivity<T>extends AppCompatActivity {

    protected DrawerLayout mRootView;//侧拉界面
    protected FrameLayout flActivityContainer;//显示Activity主窗口
    private Toast mToast;
    private Fragment mFragment;//fragment运行类
    private List<TurnBackListener> mTurnBackListeners=new ArrayList<>();//回调监听集合
    private long mBackPressedTime;//记录上次点击退回的事件
    public ArrayMap<String, String> mPostTypes = new ArrayMap<>();// 所有请求类型
    public interface  TurnBackListener{//自定义一个回调接口用于管理回退事件
       boolean onTurnBack();
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    /*
     * 加载框显示
     * */
    public void loding(String loadingstr) {
        XPopup.get(this).asLoading(loadingstr).show();
    }

    /*
     *隐藏弹框
     *  */
    public void finishLoding() {
        XPopup.get(this).dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(BaseResponse<T> response){
        httpOnResult(response);
    };
    protected  abstract void httpOnResult(BaseResponse<T> response);//接口成功返回回调
    /*
     * 错误情况
     * */
    public void error(BaseResponse<T> response){
        XPopup.get(this).autoDismiss(true).asConfirm("提示",response.getMsg(),null,null).show();
    }

    public void  addOnTurnBackListener(TurnBackListener l){
        this.mTurnBackListeners.add(l);
    }
    private NavigationView.OnNavigationItemSelectedListener mListenre=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){

            }

            return false;
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initStatusBar();
        initDates();
        initViews();
        IMMLeaks.fixFocusedViewLeak(this.getApplication());//处理键盘输入内存泄漏问题
    }
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup rootView = (ViewGroup) ((ViewGroup)findViewById(android.R.id.content)).getChildAt(0);
            ViewCompat.setFitsSystemWindows(rootView,false);
            rootView.setClipToPadding(true);
        }
    }
    /*
    * 初始化View
    * */
    protected void  initViews(){
        flActivityContainer=findViewById(R.id.activity_container);
        flActivityContainer.addView(LayoutInflater.from(this).inflate(getLayoutId(), flActivityContainer, false));
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(mListenre);
        mRootView = findViewById(R.id.root_layout);
        ButterKnife.bind(this);
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {
        if (mRootView.isDrawerOpen(GravityCompat.START)) {
            mRootView.closeDrawer(GravityCompat.START);
        } else {
            mRootView.openDrawer(GravityCompat.START);
        }
    }


    @LayoutRes
    protected abstract int getLayoutId();
    /*初始化数据
    * */
    protected  void initDates(){}

    @Override
    public void onBackPressed() {

       for(TurnBackListener listener :mTurnBackListeners){
           if(listener.onTurnBack()) return;
       }
       if(JCVideoPlayer.backPress()){
           return;
       }
        if (this instanceof MainActivity) {
            long curTime = SystemClock.uptimeMillis();
            if ((curTime - mBackPressedTime) < (3 * 1000)) {
                finish();
            } else {
                mBackPressedTime = curTime;
                toastLong(this.getString(R.string.tip_double_click_exit));
            }
        } else {
            super.onBackPressed();
        }
    }
    /*
    * 吐司信息
    * */
    public void toastLong(String text){
        toast(text,Toast.LENGTH_LONG);
    }
    private void  toast(final String text,final int duration){
        if(!TextUtils.isEmpty(text)){
            runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  if(mToast==null){
                                      mToast=Toast.makeText(getApplicationContext(),text,duration);

                                  }else{
                                      mToast.setText(text);
                                      mToast.setDuration(duration);
                                  }
                                  mToast.show();
                              }
                          }

            );

        }
    }
    /**
     * 打开 Activity 的同时传递一个数据
     */
    protected <V extends Serializable> void openActivity(Class<?> cls, String key, V value) {
        openActivity(this, cls, key, value);
    }

    /**
     * 打开 Activity 的同时传递一个数据
     */
    public <V extends Serializable> void openActivity(Context context, Class<?> cls, String key, V value) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }
    /*
    * 添加Fragment
    * */
    public void addFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mFragment != null) {
                    transaction.hide(mFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mFragment != null) {
                    transaction.hide(mFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            mFragment = fragment;
            transaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }
/*
* 清除所有fragment
* */
    @SuppressWarnings("RestrictedApi")
    protected void clearOldFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (transaction == null || fragments == null || fragments.size() == 0)
            return;
        boolean doCommit = false;
        for (Fragment fragmentOld : fragments) {
            if (fragmentOld != fragment && fragmentOld != null) {
                transaction.remove(fragmentOld);
                doCommit = true;
            }
        }
        if (doCommit)
            transaction.commitNow();
    }
    /**
     * 请求权限
     *
     * 如果权限被拒绝过，则提示用户需要权限
     */
    @TargetApi(Build.VERSION_CODES.M)
     protected void requestPermission(final String[] permission,int  rationale, final int requestCode){
        if(shouldShowRequestPermissionRationale(permission[0])){
            XPopup.get(BaseActivity.this).autoDismiss(true).asConfirm("权限提示",getResources().getString(rationale),new OnConfirmListener(){
                @Override
                public void onConfirm() {
                    requestPermissions(permission, requestCode);
                }
            }, new OnCancelListener(){
                @Override
                public void onCancel() {
                }
            }).show();


        }else{
            requestPermissions(permission, requestCode);
        }
        }


}
