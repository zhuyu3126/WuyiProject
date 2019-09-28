package com.manage.tn.wuyi_sport.club.fragment.main;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.danmo.commonapi.bean.BaseResponse;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.fragment.GuoWaiClubFragment;
import com.manage.tn.wuyi_sport.club.fragment.TransferFragment;

public class TransferMainFragment extends BaseFragment {
    FragmentTransaction transaction;
    @Override
    protected void httpOnResult(BaseResponse response) {
    }

    @Override
    protected void lazyLoad() {
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=6;
        headFragment.channelName="转会";
        headFragment.recordId="";
        transaction.add(R.id.headView4,headFragment,"HeadFragment");
        TransferFragment transferFragment=new TransferFragment();
        transaction.replace(R.id.contentView4,transferFragment,"TransferFragment");
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onVisible() {
        super.onVisible();
        if(isPrepared){

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main4;
    }
}
