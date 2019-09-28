package com.manage.tn.wuyi_sport.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.activity.ClubMainActivity;
import com.manage.tn.wuyi_sport.gym.activity.GymMainActivity;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.home.provider.BannerHeadProvider;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;
import com.manage.tn.wuyi_sport.wuxiao.activity.WuXiaoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeMainFragment extends BaseFragment {
    @BindView(R.id.tab_nav)
    public TabLayout mTabNav;//导航栏
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @Override
    protected void lazyLoad() {
    }
    @Override
    protected void initViews(ViewHolder holder, View root) {
        toolbar.setTitle("");
        mTabNav.removeAllTabs();
        mTabNav.addTab(mTabNav.newTab().setText("武校 "));
        mTabNav.addTab(mTabNav.newTab().setText("自由搏击"));
        mTabNav.addTab(mTabNav.newTab().setText("跆拳道 "));
        mTabNav.addTab(mTabNav.newTab().setText("健身房 "));
        mTabNav.addTab(mTabNav.newTab().setText("拳击 "));
        mTabNav.addTab(mTabNav.newTab().setText("散打 "));
        mPostTypes.put(CommonApi.homeImple.selectBannerList(6,"首页",""),"selectBannerList") ;
        FragmentTransaction transaction = ((BaseActivity)mContext).getSupportFragmentManager().beginTransaction();
        HomeContentFragment homeContentFragment=new HomeContentFragment();
        transaction.add(R.id.homeContent_view,homeContentFragment,"HomeContentFragment");
        transaction.commitAllowingStateLoss();
    }

    @OnClick({R.id.wxTab,R.id.jlbTab,R.id.jsfTab,R.id.mxTab,R.id.scTab})
    public  void TabOnClick(View  view){
        switch (view.getId()){
            case R.id.wxTab:
                WuXiaoActivity.start(((BaseActivity)mContext));
                break;
            case R.id.jlbTab:
                ClubMainActivity.start(((BaseActivity)mContext));
                break;
            case R.id.jsfTab:
                GymMainActivity.start((BaseActivity)mContext);
                break;
            case R.id.mxTab:
                break;
            case R.id.scTab:
                break;

        }


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_main;
    }



    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())&&mPostTypes.get(response.getUuid()).equals("selectBannerList")){
            mPostTypes.remove(response.getUuid());
            if(response.getCode()== Constant.SUCCESS){
                List<BannerItem> list=response.getRows();
                List<String> images=new ArrayList<>();
                for(BannerItem bannerItem:list){
                    if(bannerItem.getPlayType()==2){
                        images.add(bannerItem.getBannerPicture());
                    }

                }
                banner.setDataAdapter(images,new BannerViewAdapter());
                setListener();
            }else{
                List<String> images=new ArrayList<>();
                banner.setDataAdapter(images,new BannerViewAdapter());
                setListener();
            }
        }


    }

    public void setListener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {

            }
        });
        mTabNav.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch (tab.getPosition()){
                  case 0:
                      WuXiaoActivity.start(((BaseActivity)mContext));
                      break;
                  case 3:
                      GymMainActivity.start((BaseActivity)mContext);
                      break;
                  default:
                      ClubMainActivity.start(((BaseActivity)mContext));
                      break;


              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
