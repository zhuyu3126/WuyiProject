package com.danmo.commonapi.bean.home.school;

import java.io.Serializable;

public class VideoItem implements Serializable {
    /** 视频Id */
    private int videoId;
    /** 视频名称 */
    private String name;
    /** 是否为横幅视频 0：否  1：是 */
    private int isBanner;
    /** 视频类型:1,shcool,学校;2,coach,教练;3,gym,健身房;4,schoolclass,班级;5,club,俱乐部 */
    private int videoType;
    /** 被记录类型id */
    private int recordId;
    /** 视频频道Id */
    private int videoChannelId;
    /** 上传人Id */
    private long userId;
    /** 视频图片路径 */
    private String photoUrlString;
    /** 视频路径 */
    private String videoUrlString;
    /** 浏览数 */
    private int readNum;
    /** 初审人id */
    private long firstCheckUserId;
    /** 审核人id */
    private long checkUserId;
    /** 审核意见 */
    private String checkMemo;
    /** 审核状态：0，doing，审核中；1001，firstSuccess，初审通过/初审成：1，success，通过/成功；2，failed，不通过/失败； */
    private int checkStatus;
    /** 发布时间 (审核通过的时间)*/
 
    private String publishTime;
    /** 评论个数 */
    private int commentsNum;
    /** 收藏个数 */
    private int collectionNum;
    /** 关注个数 */
    private int focusNum;
    /** 点赞数 */
    private int favorNum;
    /** 状态 0-无效；1-有效 */
    private int status;


    /** 上传人名称 */
    private String userName;
    /** 频道名称 */
    private String channelName;
    /** 关注状态 0-已关注；1-未关注*/
    private int focusStatus;
    /** 点赞状态 0-已点赞；1-未点赞*/
    private int favorStatus;
    /** 收藏状态 0-已收藏；1-未收藏*/
    private int collectStatus;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(int isBanner) {
        this.isBanner = isBanner;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getVideoChannelId() {
        return videoChannelId;
    }

    public void setVideoChannelId(int videoChannelId) {
        this.videoChannelId = videoChannelId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPhotoUrlString() {
        return photoUrlString;
    }

    public void setPhotoUrlString(String photoUrlString) {
        this.photoUrlString = photoUrlString;
    }

    public String getVideoUrlString() {
        return videoUrlString;
    }

    public void setVideoUrlString(String videoUrlString) {
        this.videoUrlString = videoUrlString;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public long getFirstCheckUserId() {
        return firstCheckUserId;
    }

    public void setFirstCheckUserId(long firstCheckUserId) {
        this.firstCheckUserId = firstCheckUserId;
    }

    public long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(long checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getCheckMemo() {
        return checkMemo;
    }

    public void setCheckMemo(String checkMemo) {
        this.checkMemo = checkMemo;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public int getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(int focusNum) {
        this.focusNum = focusNum;
    }

    public int getFavorNum() {
        return favorNum;
    }

    public void setFavorNum(int favorNum) {
        this.favorNum = favorNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getFocusStatus() {
        return focusStatus;
    }

    public void setFocusStatus(int focusStatus) {
        this.focusStatus = focusStatus;
    }

    public int getFavorStatus() {
        return favorStatus;
    }

    public void setFavorStatus(int favorStatus) {
        this.favorStatus = favorStatus;
    }

    public int getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(int collectStatus) {
        this.collectStatus = collectStatus;
    }
}
