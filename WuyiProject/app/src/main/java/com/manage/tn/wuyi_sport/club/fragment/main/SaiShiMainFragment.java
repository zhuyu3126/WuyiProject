package com.manage.tn.wuyi_sport.club.fragment.main;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.danmo.commonapi.bean.BaseResponse;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.fragment.SaiShiFragment;
import com.manage.tn.wuyi_sport.club.fragment.TransferFragment;

public class SaiShiMainFragment extends BaseFragment {
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
        headFragment.channelName="赛事联盟";
        headFragment.recordId="";
        transaction.add(R.id.headView3,headFragment,"HeadFragment");
            SaiShiFragment saiShiFragment=new SaiShiFragment();
            transaction.replace(R.id.contentView3,saiShiFragment,"SaiShiFragment");
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onVisible() {
        super.onVisible();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main3;
    }
}
