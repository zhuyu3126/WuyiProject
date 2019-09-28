package com.manage.tn.wuyi_sport.wuxiao.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danmo.commonapi.CommonApi;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonutil.DateUtil;
import com.manage.tn.wuyi_sport.R;
import com.manage.tn.wuyi_sport.base.BaseFragment;
import com.manage.tn.wuyi_sport.base.ViewHolder;
import com.manage.tn.wuyi_sport.home.adapter.BannerViewAdapter;
import com.manage.tn.wuyi_sport.util.GlideRoundTransform;
import com.manage.tn.wuyi_sport.widget.banner.BannerWrapperView;
import com.manage.tn.wuyi_sport.widget.banner.OnBannerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class JianJieFragment extends BaseFragment {

    public SchoolItem schoolItem;
    @BindView(R.id.banner)
    public BannerWrapperView banner;
    @BindView(R.id.guanZhuBtn)
    Button guanZhuBtn;
    @Override
    protected void initViews(ViewHolder holder, View root) {
        lazyLoad();
        schoolItem= (SchoolItem) getArguments().getSerializable("schoolItem");
        guanZhuBtn.setActivated(true);
        if(schoolItem!=null){
            holder.setText(R.id.name, DateUtil.isEmpty(schoolItem.getName())?"":schoolItem.getName());
            holder.setText(R.id.remark,DateUtil.isEmpty(schoolItem.getRemark())?"":schoolItem.getRemark());
            holder.setText(R.id.admissionsProfile,DateUtil.isEmpty(schoolItem.getAdmissionsProfile())?"":schoolItem.getAdmissionsProfile());
            ImageView item_image=holder.get(R.id.photo);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_placeholder)
                    .transform(new GlideRoundTransform(mContext, 8))
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(mContext)
                    .load(Constant.IMAGE_URL+schoolItem.getPhoto())
                    .apply(options)
                    .into(item_image);
        }

    }


    @Override
    protected void httpOnResult(BaseResponse response) {
        if(null!=mPostTypes.get(response.getUuid())&&mPostTypes.get(response.getUuid()).equals("selectBannerList")){
            mPostTypes.remove(response.getUuid());
            if(response.getCode()== Constant.SUCCESS){
                List<BannerItem> list=response.getRows();
                List<String> images=new ArrayList<>();
                for(BannerItem bannerItem:list){
                    if(bannerItem.getPlayType()==2){
                        images.add(bannerItem.getBannerPicture());
                    }

                }
                banner.setDataAdapter(images,new BannerViewAdapter());
                setListener();
            }else{
                List<String> images=new ArrayList<>();
                banner.setDataAdapter(images,new BannerViewAdapter());
                setListener();
            }
        }
    }

    @Override
    protected void lazyLoad() {
        mPostTypes.put(CommonApi.homeImple.selectBannerList(1,"简介","1"),"selectBannerList") ;
    }

    public void setListener(){
        banner.setOnItemClickListener(new OnBannerItemClickListener() {
            @Override
            public void onBannerItemClick(Object data, int position) {

            }
        });
    }
    @Override
    protected int getLayoutId() {
        return R.layout.jianjie_view;
    }
}
