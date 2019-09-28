package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;

import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;

public class MiddleClubBaoMingProvider extends BaseViewProvider<ClubItem> {

    public MiddleClubBaoMingProvider(@NonNull Context context) {
        super(context, R.layout.club_middle_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, ClubItem bean) {
        holder.setText(R.id.club_name, DateUtil.isEmpty(bean.getClubName())?"":bean.getClubName());
        holder.setText(R.id.time, "营业时间: "+(DateUtil.isEmpty(bean.getBusinessDate())?"":bean.getBusinessDate())+(DateUtil.isEmpty(bean.getBusinessTime())?"":bean.getBusinessTime()));
    }
}
