package com.danmo.commonapi.bean.home.club;

import com.danmo.commonapi.bean.BaseItem;

public class ClubItem extends BaseItem {
    /** 唯一编号 */
    private int clubId;
    /** 俱乐部 */
    private String clubName;
    /** 营业执照 */
    private String businessLicense;
    /** 俱乐部法人用户 */
    private long userId;
    /** 身份证正面 */
    private String idFront;
    /** 身份证反面 */
    private String idBack;
    /** 国家 :1,domestic,国内;2,international,国际; */
    private int country;
    /** 俱乐部类型 */
    private long clubType;
    /** 地区Id */
    private int districtsId;
    /** 俱乐部地址 */
    private String clubAddress;
    /** 客服电话 */
    private int customerServicePhone;
    /** 联系人 */
    private String linkman;
    /** 俱乐部联系电话 */
    private String linkphone;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 介绍视频地址 */
    private String video;
    /** 俱乐部图片 */
    private String photo;
    /** 评分 */
    private double scoreNum;
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
    /** 招聘教练协议 */
    private String recruitCoachAgreement;
    /** 招聘队员协议 */
    private String recruitMemberAgreement;
    /** 营业日期 */
    private String businessDate;
    /** 营业时间 */
    private String businessTime;
    /** 状态 0-无效 ；1-有效 */
    private int status;

    /** 关注状态 0-已关注；1-未关注*/
    private int focusStatus;
    /** 点赞状态 0-已点赞；1-未点赞*/
    private int favorStatus;
    /** 收藏状态 0-已收藏；1-未收藏*/
    private int collectStatus;
    /** 评价*/
    private String comment;
    /** 地区名称 */
    private String districtsName;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }

    public String getIdBack() {
        return idBack;
    }

    public void setIdBack(String idBack) {
        this.idBack = idBack;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public long getClubType() {
        return clubType;
    }

    public void setClubType(long clubType) {
        this.clubType = clubType;
    }

    public int getDistrictsId() {
        return districtsId;
    }

    public void setDistrictsId(int districtsId) {
        this.districtsId = districtsId;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public int getCustomerServicePhone() {
        return customerServicePhone;
    }

    public void setCustomerServicePhone(int customerServicePhone) {
        this.customerServicePhone = customerServicePhone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(double scoreNum) {
        this.scoreNum = scoreNum;
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

    public String getRecruitCoachAgreement() {
        return recruitCoachAgreement;
    }

    public void setRecruitCoachAgreement(String recruitCoachAgreement) {
        this.recruitCoachAgreement = recruitCoachAgreement;
    }

    public String getRecruitMemberAgreement() {
        return recruitMemberAgreement;
    }

    public void setRecruitMemberAgreement(String recruitMemberAgreement) {
        this.recruitMemberAgreement = recruitMemberAgreement;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDistrictsName() {
        return districtsName;
    }

    public void setDistrictsName(String districtsName) {
        this.districtsName = districtsName;
    }
}
