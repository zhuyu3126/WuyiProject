package com.manage.tn.wuyi_sport.club.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseViewPagerAdapter;
import com.manage.tn.wuyi_sport.club.fragment.ClubJianJieFragment;
import com.manage.tn.wuyi_sport.club.fragment.ClubVideoFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.ClubBaoMingMainFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.ClubDuiYuanMainFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.ClubJiaoLianMainFragment;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.widget.picker.SubTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ClubDetialActivity extends BaseActivity {
    @BindView(R.id.tab_nav)
    public TabLayout mTabNav;//导航栏
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.viewPager)
    public ViewPager mBaseViewPager;//用于显示不同nav下的内容
    public BaseViewPagerAdapter mAdapter;
    @BindView(R.id.title_text)
    TextView title_text;
    static  ClubItem clubItem;
    @Override
    protected void initViews() {
        super.initViews();
        title_text.setText(DateUtil.isEmpty(clubItem.getClubName())?"":clubItem.getClubName());
        toolbar.setNavigationOnClickListener(view -> finish());
        mAdapter=new BaseViewPagerAdapter(this,getSupportFragmentManager(),getPages());
        mBaseViewPager.setAdapter(mAdapter);
        mTabNav.setupWithViewPager(mBaseViewPager);
        mBaseViewPager.setCurrentItem(0,true);
    }

    public static void start(Activity activity , ClubItem c){
        activity.startActivity(new Intent(activity,ClubDetialActivity.class));
        clubItem=c;
    }
    private List<BaseViewPagerAdapter.PagerInfo> getPages(){
        List<BaseViewPagerAdapter.PagerInfo> listPages=new ArrayList<>();
        Bundle bundle=new Bundle();
        bundle.putString("sub_tab","tab");
        bundle.putSerializable("clubItem",clubItem);
        List<SubTab> list = buildPickActiveData();
        for(int i=0;i<list.size();i++) {
            switch (list.get(i).getName()) {
                case "简介":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClubJianJieFragment.class,bundle));
                    break;
                case "教练":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClubJiaoLianMainFragment.class,bundle));
                    break;
                case "队员":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(), ClubDuiYuanMainFragment.class,bundle));
                    break;
                case "视频":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClubVideoFragment.class,bundle));
                    break;
                case "报名":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClubBaoMingMainFragment.class,bundle));
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

    @Override
    protected void httpOnResult(BaseResponse response) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.model_detial_main;
    }
}
