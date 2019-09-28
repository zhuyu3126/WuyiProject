package com.danmo.commonapi.bean.home.club;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
import java.math.BigDecimal;
/*
* 赛事
* */
public class EventItem extends BaseItem implements Serializable {
    /** 唯一编号 */
    private int id;
    /** 主办方名称 */
    private String sponsorName;
    /** 主办方联系电话 */
    private String linkphone;
    /** 是否有赛事经验 */
    private int matchExperience;
    /** 营业执照 */
    private String businessLicense;
    /** 法人名称 */
    private String legalPersonName;
    /** 法人身份证号 */
    private String legalIdNum;
    /** 身份证正面 */
    private String idFront;
    /** 身份证反面 */
    private String idBack;
    /** 赛事名称 */
    private String matchName;
    /** 赛事等级 */
    private String matchLevel;
    /** 赛事性质 */
    private int matchNature;
    /** 赛事类型Id */
    private int matchTypeId;
    /** 赛事宣传图片 */
    private String picture;
    /** 运动员级别 */
    private int athletesLevel;
    /** 运动员出场费 */
    private BigDecimal athletesExitFee;
    /** 明星运动员出场费 */
    private BigDecimal starAthletesExitFee;
    /** 举办地区Id */
    private int directId;
    /** 举办地址 */
    private String address;
    /** 已报名数 */
    private int signupNum;
    /** 可报名数 */
    private int accommodateNum;
    /** 发布人id */
    private long publishUserId;
    /** 审核状态：0，doing，审核中；1，success，通过/成功；2，failed，不通过/失败； */
    private int checkStatus;
    /** 是否签合同：0-未签，1-已签 */
    private int contractStatus;
    /** 是否交押金  0-未交；1-已交 */
    private int depositStatus;
    /** 审核人Id */
    private long checkUserId;
    /** 审核意见 */
    private String checkMemo;
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
    /** 发布时间 */
   
    private String publishTime;
    /** 赛事开始时间 */
    private String startTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public int getMatchExperience() {
        return matchExperience;
    }

    public void setMatchExperience(int matchExperience) {
        this.matchExperience = matchExperience;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalIdNum() {
        return legalIdNum;
    }

    public void setLegalIdNum(String legalIdNum) {
        this.legalIdNum = legalIdNum;
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

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public int getMatchNature() {
        return matchNature;
    }

    public void setMatchNature(int matchNature) {
        this.matchNature = matchNature;
    }

    public int getMatchTypeId() {
        return matchTypeId;
    }

    public void setMatchTypeId(int matchTypeId) {
        this.matchTypeId = matchTypeId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAthletesLevel() {
        return athletesLevel;
    }

    public void setAthletesLevel(int athletesLevel) {
        this.athletesLevel = athletesLevel;
    }

    public BigDecimal getAthletesExitFee() {
        return athletesExitFee;
    }

    public void setAthletesExitFee(BigDecimal athletesExitFee) {
        this.athletesExitFee = athletesExitFee;
    }

    public BigDecimal getStarAthletesExitFee() {
        return starAthletesExitFee;
    }

    public void setStarAthletesExitFee(BigDecimal starAthletesExitFee) {
        this.starAthletesExitFee = starAthletesExitFee;
    }

    public int getDirectId() {
        return directId;
    }

    public void setDirectId(int directId) {
        this.directId = directId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(int contractStatus) {
        this.contractStatus = contractStatus;
    }

    public int getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(int depositStatus) {
        this.depositStatus = depositStatus;
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
