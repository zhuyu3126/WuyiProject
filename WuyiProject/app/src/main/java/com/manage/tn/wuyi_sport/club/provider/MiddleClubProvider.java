package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.danmo.commonapi.bean.home.club.ClubType;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.EventBusMsg;

import org.greenrobot.eventbus.EventBus;

public class MiddleClubProvider extends BaseViewProvider<ClubType> {

    public MiddleClubProvider(@NonNull Context context) {
        super(context, R.layout.type_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, ClubType bean) {
        if(bean.getType()==1){
            ((RadioGroup)holder.get(R.id.type_radio)).setVisibility(View.VISIBLE);
            ((RadioGroup)holder.get(R.id.type_radio2)).setVisibility(View.GONE);
            ((LinearLayout)holder.get(R.id.srcoll_layout)).setVisibility(View.GONE);
            ((RadioGroup)holder.get(R.id.type_radio)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    EventBusMsg eventBusMsg=new EventBusMsg();
                    switch (i){
                        case  R.id.zybj_tab:
                            eventBusMsg.setRadiotype(45);
                            break;
                        case  R.id.tqd_tab:
                            eventBusMsg.setRadiotype(47);
                            break;
                        case  R.id.qj_tab:
                            eventBusMsg.setRadiotype(49);
                            break;
                        case  R.id.tj_tab:
                            eventBusMsg.setRadiotype(51);
                            break;
                        case  R.id.mma_tab:
                            eventBusMsg.setRadiotype(53);
                            break;

                    }
                    EventBus.getDefault().post(eventBusMsg);
                }
            });
        }else if(bean.getType()==2){
            ((RadioGroup)holder.get(R.id.type_radio)).setVisibility(View.GONE);
            ((RadioGroup)holder.get(R.id.type_radio2)).setVisibility(View.VISIBLE);
            ((LinearLayout)holder.get(R.id.srcoll_layout)).setVisibility(View.GONE);
            ((RadioButton)holder.get(R.id.grzl_tab)).setActivated(true);
            ((RadioGroup)holder.get(R.id.type_radio2)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    EventBusMsg eventBusMsg=new EventBusMsg();
                    switch (i){
                        case  R.id.dy_tab:
                            eventBusMsg.setRadiotype(0);
                            break;
                        case  R.id.tb_tab:
                            eventBusMsg.setRadiotype(1);
                            break;
                        case  R.id.jl_tab:
                            eventBusMsg.setRadiotype(2);
                            break;
                        case  R.id.grzl_tab:

                            break;


                    }
                    EventBus.getDefault().post(eventBusMsg);
                }
            });
        }else if(bean.getType()==3){
            ((RadioGroup)holder.get(R.id.type_radio)).setVisibility(View.GONE);
            ((RadioGroup)holder.get(R.id.type_radio2)).setVisibility(View.GONE);
            ((LinearLayout)holder.get(R.id.srcoll_layout)).setVisibility(View.VISIBLE);
            ((RadioButton)holder.get(R.id.ssfb_tabsc)).setActivated(true);
            ((RadioButton)holder.get(R.id.ssfb_tabsc)).setOnClickListener(view -> {
            });
            ((RadioGroup)holder.get(R.id.scroll_radio)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    EventBusMsg eventBusMsg=new EventBusMsg();
                    switch (i){
                        case  R.id.zybj_tabsc:
                            eventBusMsg.setRadiotype(27);
                            break;
                        case  R.id.tqd_tabsc:
                            eventBusMsg.setRadiotype(29);
                            break;
                        case  R.id.qj_tabsc:
                            eventBusMsg.setRadiotype(31);
                            break;
                        case  R.id.tj_tabsc:
                            eventBusMsg.setRadiotype(0);
                            break;
                        case  R.id.mma_tabsc:
                            eventBusMsg.setRadiotype(0);
                            break;



                    }
                    EventBus.getDefault().post(eventBusMsg);
                }
            });


        }



    }
}
