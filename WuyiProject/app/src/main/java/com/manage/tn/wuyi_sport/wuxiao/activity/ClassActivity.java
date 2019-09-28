package com.manage.tn.wuyi_sport.wuxiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseViewPagerAdapter;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.widget.picker.SubTab;
import com.manage.tn.wuyi_sport.wuxiao.fragment.ClassJiaoLianFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.ClassMainFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.ClassVideDetialFragment;
import com.manage.tn.wuyi_sport.wuxiao.fragment.DuiYuanFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ClassActivity extends BaseActivity {
    @BindView(R.id.tab_nav)
    public TabLayout mTabNav;//导航栏
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.viewPager)
    public ViewPager mBaseViewPager;//用于显示不同nav下的内容
    public BaseViewPagerAdapter mAdapter;
    static ClassItem classItem;//当前班级
    @BindView(R.id.title_text)
    TextView title_text;
    @Override
    protected void initViews() {
        super.initViews();
        if(classItem!=null){
            title_text.setText(DateUtil.isEmpty(classItem.getName())?"":classItem.getName());
        }
        toolbar.setNavigationOnClickListener(view -> finish());
        mAdapter=new BaseViewPagerAdapter(this,getSupportFragmentManager(),getPages());
        mBaseViewPager.setAdapter(mAdapter);
        mTabNav.setupWithViewPager(mBaseViewPager);
        mBaseViewPager.setCurrentItem(0,true);
    }
    public static void start(Activity activity , ClassItem s){
        activity.startActivity(new Intent(activity,ClassActivity.class));
        classItem=s;
    }
    @Override
    protected void httpOnResult(BaseResponse response) {

    }


    private List<BaseViewPagerAdapter.PagerInfo> getPages(){
        List<BaseViewPagerAdapter.PagerInfo> listPages=new ArrayList<>();
        Bundle bundle=new Bundle();
        bundle.putString("sub_tab","tab");
        List<SubTab> list =  list = buildPickActiveData();
        bundle.putSerializable("classItem",classItem);
        for(int i=0;i<list.size();i++) {
            switch (list.get(i).getName()) {
                case "班级":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClassMainFragment.class,bundle));
                    break;
                case "教练":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClassJiaoLianFragment.class,bundle));
                    break;
                case "队员":
                    bundle.putInt("type",1);
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),DuiYuanFragment.class,bundle));
                    break;
                case "视频":
                    listPages.add(new BaseViewPagerAdapter.PagerInfo(list.get(i).getName(),ClassVideDetialFragment.class,bundle));
                    break;
                default:

                    break;
            }
        }
        return listPages;
    }


    private List<SubTab> buildPickActiveData(){
        List<SubTab> list = new ArrayList<>();
        for (int i = 0; i < Config.classTabTitles.length; i++) {
            SubTab tab = new SubTab();
            if (i == 0) {
                tab.setFixed(true);
            }
            tab.setName( Config.classTabTitles[i]);
            list.add(tab);
        }
        return list;


    }
    @Override
    protected int getLayoutId() {
        return R.layout.model_detial_main;
    }
}
