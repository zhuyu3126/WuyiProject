package com.manage.tn.wuyi_sport.base.nav;


import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.danmo.commonapi.bean.BaseResponse;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.TestFragment;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.fragment.HomeMainFragment;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.util.fastcolck.SingleClick;

import java.util.List;

/**
 * 底部导航栏内容 用于切换不同菜单NAVBtn调用不同的fragment页面
 */
public class NavFragment extends BaseFragment implements View.OnClickListener {
    private NavigationButton mNavHome;//首页
    private NavigationButton mNavVideo;//视频
    private NavigationButton mNavLiveStreaming;//直播
    private NavigationButton mNavMessage;//消息
    private NavigationButton navUserCentry;//足迹
    private LinearLayout  nav_layout;
    private int mContainerId;
    private NavigationButton mCurrentNavButton;
    private OnNavigationReselectListener mOnNavigationReselectListener;

    @Override
    protected void lazyLoad() {

    }

    public NavFragment() {
    }
    /*
    * 获取数据
    * */
    @Override
    protected void httpOnResult(BaseResponse response) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        mNavHome = holder.get(R.id.nav_item_home);
        mNavVideo = holder.get(R.id.nav_Video);
        mNavLiveStreaming=holder.get(R.id.nav_LiveStreaming);
        mNavMessage = holder.get(R.id.nav_Message);
        navUserCentry = holder.get(R.id.nav_userCentry);
        nav_layout=holder.get(R.id.nav_layout);
        holder.setOnClickListener(this, R.id.nav_item_home);
        holder.setOnClickListener(this, R.id.nav_Video);
        holder.setOnClickListener(this, R.id.nav_LiveStreaming);
        holder.setOnClickListener(this, R.id.nav_Message);
        holder.setOnClickListener(this, R.id.nav_userCentry);
        ShapeDrawable lineDrawable = new ShapeDrawable(new BorderShape(new RectF(0, 1, 0, 0)));
        lineDrawable.getPaint().setColor(getResources().getColor(R.color.white));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{
                new ColorDrawable(getResources().getColor(R.color.transparent)),
                lineDrawable
        });
       // nav_layout.setBackgroundDrawable(layerDrawable);
        if (Config.navigationTitles.length < 5) {
            return;
        }
        mNavHome.init(R.drawable.tab_icon_home,
                Config.navigationTitles[0],
                HomeMainFragment.class);

        mNavVideo.init(R.drawable.tab_icon_video,
                Config.navigationTitles[1],
                TestFragment.class);


        mNavLiveStreaming.init(R.drawable.tab_icon_living,
                Config.navigationTitles[2],
                TestFragment.class);

        mNavMessage.init(R.drawable.tab_icon_message,
                Config.navigationTitles[3],
                TestFragment.class);
        navUserCentry.init(R.drawable.tab_icon_user,
                Config.navigationTitles[4],
                TestFragment.class);
        clearOldFragment();
        doSelect(mNavHome);
        lazyLoad();
    }
    @SingleClick
    @Override
    public void onClick(View v) {
        if (v instanceof NavigationButton) {
            NavigationButton nav = (NavigationButton) v;
            doSelect(nav);
        }
    }

    public void setup(int contentId, OnNavigationReselectListener listener) {
        mContainerId = contentId;
        mOnNavigationReselectListener = listener;
    }



    private void clearOldFragment() {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        if (transaction == null || fragments == null || fragments.size() == 0)
            return;
        boolean doCommit = false;
        for (Fragment fragment : fragments) {
            if (fragment != this && fragment != null) {
                transaction.remove(fragment);
                doCommit = true;
            }
        }
        if (doCommit)
            transaction.commitNow();
    }
/*
* 选择菜单
* */
    private void doSelect(NavigationButton newNavButton) {
        NavigationButton oldNavButton = null;
        if (mCurrentNavButton != null) {
            oldNavButton = mCurrentNavButton;
            if (oldNavButton == newNavButton) {
                onReselect(oldNavButton);
                return;
            }
            oldNavButton.setSelected(false);
        }
        newNavButton.setSelected(true);
        doTabChanged(oldNavButton, newNavButton);
        mCurrentNavButton = newNavButton;
    }
/*
* 菜单切换
* */
    private void doTabChanged(NavigationButton oldNavButton, NavigationButton newNavButton) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        if (oldNavButton != null) {
            if (oldNavButton.getFragment() != null) {
                ft.detach(oldNavButton.getFragment());
            }
        }
        if (newNavButton != null) {
            if (newNavButton.getFragment() == null) {
                Fragment fragment = Fragment.instantiate(mContext,
                        newNavButton.getClx().getName(), null);
                ft.add(mContainerId, fragment, newNavButton.getTag());
                newNavButton.setFragment(fragment);
            } else {
                ft.attach(newNavButton.getFragment());
            }
        }
        ft.commit();
    }
/*
* 取消选中的菜单效果
* */
    private void onReselect(NavigationButton navigationButton) {
        OnNavigationReselectListener listener = mOnNavigationReselectListener;
        if (listener != null) {
            listener.onReselect(navigationButton);
        }
    }

    public interface OnNavigationReselectListener {
        void onReselect(NavigationButton navigationButton);
    }
}
