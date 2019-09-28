package com.manage.tn.wuyi_sport.club.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.danmo.commonapi.bean.BaseResponse;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseViewPagerAdapter;
import com.manage.tn.wuyi_sport.club.fragment.main.GuoNeiClubMainFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.GuoWaiClubMainFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.SaiShiMainFragment;
import com.manage.tn.wuyi_sport.club.fragment.main.TransferMainFragment;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.widget.picker.SubTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ClubMainActivity extends BaseActivity {
    @BindView(R.id.tab_nav)
    public TabLayout mTabNav;//导航栏
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.viewPager)
    public ViewPager mBaseViewPager;//用于显示不同nav下的内容
    public BaseViewPagerAdapter mAdapter;
    @BindView(R.id.title_text)
    TextView title_text;
    @Override
    protected void initViews() {
        super.initViews();
        title_text.setText(R.string.app_name);
        toolbar.setNavigationOnClickListener(view -> finish());
        mAdapter=new BaseViewPagerAdapter(this,getSupportFragmentManager(),getPages());
        mBaseViewPager.setAdapter(mAdapter);
        mTabNav.setupWithViewPager(mBaseViewPager);
        mBaseViewPager.setCurrentItem(0,true);
    }

    public static void start(Activity activity ){
        activity.startActivity(new Intent(activity,ClubMainActivity.class));
    }
    private List<BaseViewPagerAdapter.PagerInfo> getPages(){
        List<BaseViewPagerAdapter.PagerInfo> listPages=new ArrayList<>();
        Bundle bundle=new Bundle();
        bundle.putString("sub_tab","tab");
        List<SubTab> list = buildPickActiveData();

        for(int i=0;i<list.size();i++) {
            switch (list.get(i).getName()) {
                case "国内":
                    bundle.putInt("type",1);
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),GuoNeiClubMainFragment.class,bundle));
                    break;
                case "国际":
                    bundle.putInt("type2",2);
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),GuoWaiClubMainFragment.class,bundle));
                    break;
                case "转会":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),TransferMainFragment.class,bundle));
                    break;
                case "赛事/联盟":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),SaiShiMainFragment.class,bundle));
                    break;
                default:
                    break;
            }
        }
        return listPages;
    }


    private List<SubTab> buildPickActiveData(){
        List<SubTab> list = new ArrayList<>();
        for (int i = 0; i < Config.clubTabTitles.length; i++) {
            SubTab tab = new SubTab();
            if (i == 0) {
                tab.setFixed(true);
            }
            tab.setName( Config.clubTabTitles[i]);
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
