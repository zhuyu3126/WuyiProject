package com.danmo.commonapi.bean.home;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
/*
* 首页图片轮播
* */
public class BannerItem  implements Serializable {
    int bannerId;//轮播图Id
    String bannerName;//轮播图名称
    int bannerChannelId;//banner类型Id
    int recordId;//记录id
    int playType;//'播放类型：1，video，视频；2，picture ，图片：',
    String bannerPicture;//'轮播图路径',
    String bannerVideo;//视频播放地址
    int userId;//'上传人Id'
    int  orderIndex;//排序
    int status;//'状态 0-无效；1-有效'
    String channelType;
    String  channelName;

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public int getBannerChannelId() {
        return bannerChannelId;
    }

    public void setBannerChannelId(int bannerChannelId) {
        this.bannerChannelId = bannerChannelId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPlayType() {
        return playType;
    }

    public void setPlayType(int playType) {
        this.playType = playType;
    }

    public String getBannerPicture() {
        return bannerPicture;
    }

    public void setBannerPicture(String bannerPicture) {
        this.bannerPicture = bannerPicture;
    }

    public String getBannerVideo() {
        return bannerVideo;
    }

    public void setBannerVideo(String bannerVideo) {
        this.bannerVideo = bannerVideo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
