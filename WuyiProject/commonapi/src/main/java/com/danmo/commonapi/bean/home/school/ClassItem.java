package com.danmo.commonapi.bean.home.school;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/*
* 班级
* */
public class ClassItem extends BaseItem implements Serializable {

    /** 班级编号 */
    private int classId;
    /** 班级名 */
    private String name;
    /** 托管类型 1:全托 , 2:半托 */
    private int trusteeType;
    /** 所属武校 */
    private int schoolId;
    /** 班级风采 */
    private List<String> classStyles;
    /** 班级图片 */
    private String photo;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 介绍视频地址 */
    private String video;
    /** 价格  */
    private BigDecimal price;
    /** 价格单位 */
    private String unitPrice;
    /** 已报名人数 */
    private int signupNum;
    /** 可容纳人数 */
    private int accommodateNum;
    /** 班级年龄区间 */
    private String ageRange;
    /** 浏览数 */
    private int visitNum;
    /** 评论数 */
    private int commentsNum;
    /** 收藏数 */
    private int collectionNum;
    /** 点赞数 */
    private int favorNum;
    /** 关注数 */
    private int focusNum;
    /** 状态 0-无效 ；1-有效 */
    private int status;

    /** 关注状态 0-已关注；1-未关注*/
    private int focusStatus;
    /** 点赞状态 0-已点赞；1-未点赞*/
    private int favorStatus;
    /** 收藏状态 0-已收藏；1-未收藏*/
    private int collectStatus;
    /** 教练名 */
    private String coachName;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrusteeType() {
        return trusteeType;
    }

    public void setTrusteeType(int trusteeType) {
        this.trusteeType = trusteeType;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public List<String> getClassStyles() {
        return classStyles;
    }

    public void setClassStyles(List<String> classStyles) {
        this.classStyles = classStyles;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSignupNum() {
        return signupNum;
    }

    public void setSignupNum(int signupNum) {
        this.signupNum = signupNum;
    }

    public int getAccommodateNum() {
        return accommodateNum;
    }

    public void setAccommodateNum(int accommodateNum) {
        this.accommodateNum = accommodateNum;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
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

    public int getFavorNum() {
        return favorNum;
    }

    public void setFavorNum(int favorNum) {
        this.favorNum = favorNum;
    }

    public int getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(int focusNum) {
        this.focusNum = focusNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
