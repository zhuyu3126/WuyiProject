package com.manage.tn.wuyi_sport.club.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonapi.bean.home.club.CommounItem;
import com.danmo.commonutil.DateUtil;
import com.danmo.commonutil.recyclerview.adapter.base.RecyclerViewHolder;
import com.danmo.commonutil.recyclerview.adapter.multitype.BaseViewProvider;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;

public class TransferItemProvider extends BaseViewProvider<CommounItem>{

    public TransferItemProvider(@NonNull Context context) {
        super(context, R.layout.horizern_item_view);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, CommounItem bean) {
        LinearLayout cocahLinear=holder.get(R.id.cocah_linear);
        LinearLayout clubmber_liner=holder.get(R.id.clubmber_liner);
        ImageView item_image = null;
        if(bean.getMbId()!=0){
            item_image=holder.get(R.id.image);
            clubmber_liner.setVisibility(View.VISIBLE);
            cocahLinear.setVisibility(View.GONE);
            ((TextView)holder.get(R.id.club_name)).setText(DateUtil.isEmpty(bean.getName())?"":bean.getName());
            ((TextView)holder.get(R.id.describe)).setText("战绩 "+bean.getMatchNum()+"战 "+(bean.getKoNum())+"次KO");
        }else if(bean.getBodyguardId()!=0||bean.getCoachId()!=0){
            item_image=holder.get(R.id.item_image);
            clubmber_liner.setVisibility(View.GONE);
            cocahLinear.setVisibility(View.VISIBLE);
            ((TextView)holder.get(R.id.name)).setText(DateUtil.isEmpty(bean.getName())?"":bean.getName());
            Button guanZhuBtn=(Button)holder.get(R.id.guanZhuBtn);
            guanZhuBtn.setActivated(true);
            holder.setText(R.id.goodat,(DateUtil.isEmpty(bean.getBeGoodAt())?"":"("+bean.getBeGoodAt()+")"));
            holder.setText(R.id.remark,DateUtil.isEmpty(bean.getRemark())?"":bean.getRemark());
            holder.setText(R.id.item_vc,"浏览量 "+bean.getVisitNum());
            holder.setText(R.id.favorNum,bean.getFavorNum()+" 万");
            holder.setText(R.id.focusNum,"粉丝 "+bean.getFocusNum()+"万");

        }
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new GlideRoundTransform(mContext, 8))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext)
                .load(Constant.IMAGE_URL+bean.getPhoto())
                .apply(options)
                .into(item_image);

        holder.getRootView().setOnClickListener(view -> {

        });

    }
}
