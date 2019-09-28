package com.manage.tn.wuyi_sport.club.fragment.main;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.bean.BaseResponse;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.HeadFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.club.fragment.GuoNeiClubFragment;
import com.manage.tn.wuyi_sport.home.fragment.HomeContentFragment;

public class GuoNeiClubMainFragment extends BaseFragment {
    int type;
    @Override
    protected void httpOnResult(BaseResponse response) {
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onVisible() {
        super.onVisible();

    }

    @Override
    protected void initViews(ViewHolder holder, View root) {
        type=getArguments().getInt("type");
        lazyLoad();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HeadFragment headFragment=new HeadFragment();
        headFragment.showTyp=1;
        headFragment.channelType=6;
        headFragment.channelName="国内";
        headFragment.recordId="";
        transaction.add(R.id.headView1,headFragment,"HeadFragment");
        GuoNeiClubFragment guoNeiClubFragment=new GuoNeiClubFragment();
        guoNeiClubFragment.type=type;
        transaction.add(R.id.contentView1,guoNeiClubFragment,"GuoNeiClubFragment");
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main1;
    }
}
