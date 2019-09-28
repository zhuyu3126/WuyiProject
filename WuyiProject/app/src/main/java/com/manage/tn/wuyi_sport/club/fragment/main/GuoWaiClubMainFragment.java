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

public class GuoWaiClubMainFragment extends BaseFragment {
    int type;
    @Override
    protected void httpOnResult(BaseResponse response) {
    }

    @Override
    protected void lazyLoad() {
    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        type=getArguments().getInt("type2");
        lazyLoad();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=6;
        headFragment.channelName="国际";
        headFragment.recordId="";
        transaction.add(R.id.headView2,headFragment,"HeadFragment");
        GuoWaiClubFragment guoWaiClubFragment=new GuoWaiClubFragment();
        guoWaiClubFragment.type=type;
        transaction.replace(R.id.contentView2,guoWaiClubFragment,"GuoWaiClubFragment");
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onVisible() {
        super.onVisible();


    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main2;
    }
}
