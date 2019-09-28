package com.manage.tn.wuyi_sport;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.View;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.TimeUtil;
import com.manage.tn.wuyi_sport.base.BaseActivity;
import com.manage.tn.wuyi_sport.base.nav.NavFragment;
import com.manage.tn.wuyi_sport.base.nav.NavigationButton;
import com.manage.tn.wuyi_sport.base.nav.OnTabReselectListener;
import com.manage.tn.wuyi_sport.util.Config;
import com.manage.tn.wuyi_sport.util.EventBusMsg;
import org.greenrobot.eventbus.EventBus;


public class MainActivity extends BaseActivity implements NavFragment.OnNavigationReselectListener{
    private NavFragment mNavBar;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavBar=new NavFragment();
        addFragment(R.id.fag_nav,mNavBar);
        mNavBar.setup(R.id.main_container,this);
    }

    @Override
    protected void initDates() {
        super.initDates();
    }

    @Override
    protected void httpOnResult(BaseResponse response) {

    }

    @Override
    public void onReselect(NavigationButton navigationButton) {
            Fragment fragement=navigationButton.getFragment();
            if(fragement!=null&&fragement instanceof OnTabReselectListener){
                OnTabReselectListener listener = (OnTabReselectListener) fragement;
                listener.onTabReselect();
            }
    }

}
