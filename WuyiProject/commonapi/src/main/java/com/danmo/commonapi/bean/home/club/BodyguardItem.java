package com.danmo.commonapi.bean.home.club;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
/*
* 特保
* */
public class BodyguardItem extends BaseItem implements Serializable{
    /** 唯一编号 */
    private int bodyguardId;
    /** 用户ID */
    private long userId;
    /** 姓名 */
    private String name;
    /** 绰号 */
    private String nickname;
    /** 用户性别（0男 1女 2未知） */
    private String sex;
    /** 出生年月日 */
    private String birthday;
    /** 身份证号 */
    private String idcardno;
    /** 身高 */
    private int height;
    /** 籍贯 */
    private String nativeplace;
    /** 体重 */
    private int weight;
    /** 特保图片 */
    private String photo;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 介绍视频的地址 */
    private String video;
    /** 住址 */
    private String address;
    /** 联系电话 */
    private String linkphone;
    /** 评分 */
    private double scoreNum;
    /** 擅长 */
    private String beGoodAt;
    /** 浏览数 */
    private int visitNum;
    /** 评论个数 */
    private int commentsNum;
    /** 收藏个数 */
    private int collectionNum;
    /** 关注个数 */
    private int focusNum;
    /** 点赞数 */
    private int favorNum;
    /** 状态 0-无效 ；1-有效 */
    private int status;

    public int getBodyguardId() {
        return bodyguardId;
    }

    public void setBodyguardId(int bodyguardId) {
        this.bodyguardId = bodyguardId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideoPhoto() {
        return videoPhoto;
    }

    public void setVideoPhoto(String videoPhoto) {
        this.videoPhoto = videoPhoto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(double scoreNum) {
        this.scoreNum = scoreNum;
    }

    public String getBeGoodAt() {
        return beGoodAt;
    }

    public void setBeGoodAt(String beGoodAt) {
        this.beGoodAt = beGoodAt;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
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
}
