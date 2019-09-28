package com.manage.tn.wuyi_sport.club.fragment.main;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.fragment.ClubBaoMingFragment;

public class ClubBaoMingMainFragment extends BaseFragment {
    ClubItem clubItem;
    @Override
    protected void httpOnResult(BaseResponse response) {
    }

    @Override
    protected void lazyLoad() {
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        clubItem= (ClubItem) getArguments().getSerializable("clubItem");
        lazyLoad();
        FragmentTransaction transaction =getFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=3;
        headFragment.channelName="报名";
        headFragment.recordId="3";
        transaction.add(R.id.headView1,headFragment,"HeadFragment");
        ClubBaoMingFragment clubBaoMingFragment=new ClubBaoMingFragment();
        clubBaoMingFragment.clubItem=clubItem;
        transaction.add(R.id.contentView1,clubBaoMingFragment,"ClubBaoMingFragment");
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main1;
    }
}
