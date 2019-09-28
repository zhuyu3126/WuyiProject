package com.manage.tn.wuyi_sport.wuxiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseViewPagerAdapter;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.util.EventBusMsg;
import com.manage.tn.wuyi_sport.widget.picker.SubTab;
import com.manage.tn.wuyi_sport.wuxiao.fragment.BaoMingFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.DuiYuanFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.JianJieFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.JiaoLianFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.SchoolVideoFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WuXiaoDetialActivity extends BaseActivity {
    @BindView(R.id.tab_nav)
    public TabLayout mTabNav;//导航栏
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.viewPager)
    public ViewPager mBaseViewPager;//用于显示不同nav下的内容
    public BaseViewPagerAdapter mAdapter;
    static  SchoolItem schoolItem;
    @BindView(R.id.title_text)
    TextView title_text;
    @Override
    protected void initViews() {
        super.initViews();
        if(schoolItem!=null){
            title_text.setText(DateUtil.isEmpty(schoolItem.getName())?"":schoolItem.getName());
        }
        toolbar.setNavigationOnClickListener(view -> finish());
        mAdapter=new BaseViewPagerAdapter(this,getSupportFragmentManager(),getPages());
        mBaseViewPager.setAdapter(mAdapter);
        mTabNav.setupWithViewPager(mBaseViewPager);
        mBaseViewPager.setCurrentItem(0,true);
    }

  public static void start(Activity activity , SchoolItem s){
    activity.startActivity(new Intent(activity,WuXiaoDetialActivity.class));
      schoolItem=s;
  }
    private List<BaseViewPagerAdapter.PagerInfo> getPages(){
        List<BaseViewPagerAdapter.PagerInfo> listPages=new ArrayList<>();
        Bundle bundle=new Bundle();
        bundle.putString("sub_tab","tab");
        List<SubTab> list =  list = buildPickActiveData();
        bundle.putSerializable("schoolItem",schoolItem);
        for(int i=0;i<list.size();i++) {
            switch (list.get(i).getName()) {
                case "简介":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),JianJieFragment.class,bundle));
                    break;
                case "教练":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),JiaoLianFragment.class,bundle));
                    break;
                case "队员":
                    bundle.putInt("type",0);
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),DuiYuanFragment.class,bundle));
                    break;
                case "视频":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),SchoolVideoFragment.class,bundle));
                    break;
                case "报名":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),BaoMingFragment.class,bundle));
                    break;

                default:

                    break;
            }
        }
        return listPages;
    }


    private List<SubTab> buildPickActiveData(){
        List<SubTab> list = new ArrayList<>();
        for (int i = 0; i < Config.schoolTabTitles.length; i++) {
            SubTab tab = new SubTab();
            if (i == 0) {
                tab.setFixed(true);
            }
            tab.setName( Config.schoolTabTitles[i]);
            list.add(tab);
        }
        return list;


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(EventBusMsg msg){
        mBaseViewPager.setCurrentItem(msg.getRadiotype(),true);//跳转页面
    };

    @Override
    protected int getLayoutId() {
        return R.layout.model_detial_main;
    }

    @Override
    protected void httpOnResult(BaseResponse response) {

    }
}
