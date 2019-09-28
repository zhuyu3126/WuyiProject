package com.danmo.commonapi.bean.home.school;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
import java.math.BigDecimal;
/*
* 教练
* */
public class CoachItem extends BaseItem implements Serializable {
    /**  */
    private int coachId;
    /** 用户ID */
    private long userId;
    /** 姓名 */
    private String name;
    /** 绰号 */
    private String nickname;
    /** 联系电话 */
    private String linkphone;
    /** 教练性别（0男 1女 2未知） */
    private String sex;
    /** 年龄 */
    private int age;
    /** 出生年月日 */
    private String birthday;
    /** 身份证号 */
    private String idcardno;
    /** 身份证正面 */
    private String idFront;
    /** 身份证反面 */
    private String idBack;
    /** 教练照片（个人海报） */
    private String photo;
    /** 身高 */
    private int height;
    /** 体重 */
    private int weight;
    /** 擅长 */
    private String coachTypeName;
    /** 擅长（教练类型名称） */
    private String beGoodAt;
    /** 籍贯 */
    private String nativeplace;
    /** 住址 */
    private String address;
    /** 转会要求 */
    private String transferRequire;
    /** 遵守协议 */
    private String observeAgreement;
    /** 联系人 */
    private String linkman;
    /** 联系人电话 */
    private String linkmanphone;
    /** 参加比赛次数 */
    private int matchNum;
    /** 获胜次数 */
    private int winNum;
    /** ko次数 */
    private int koNum;
    /** 级别(重量级) */
    private int level;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 介绍视频的地址 */
    private String video;
    /** 价格 */
    private BigDecimal price;
    /** 价格单位 */
    private String unitPrice;
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
    /** 预约状态 0 :未预约 , 1:已预约 */
    private int appointStatus;
    /** 预约开始时间 */
    private String appointStartTime;
    /** 是否转会： 0-否； 1-是 */
    private int isTransfer;
    /** 状态 0-无效 ；1-有效 */
    private int status;
    /** 商家类型:1,shcool,学校;2,gym,健身房 */
    private int businessType;
    /** 商家Id(学校、俱乐部、健身房) */
    private int businessId;
    /** 关注状态 0-已关注；1-未关注*/
    private int focusStatus;
    /** 点赞状态 0-已点赞；1-未点赞*/
    private int favorStatus;
    /** 收藏状态 0-已收藏；1-未收藏*/
    private int collectStatus;
    /** 班级Id */
    private int classId;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCoachTypeName() {
        return coachTypeName;
    }

    public void setCoachTypeName(String coachTypeName) {
        this.coachTypeName = coachTypeName;
    }

    public String getBeGoodAt() {
        return beGoodAt;
    }

    public void setBeGoodAt(String beGoodAt) {
        this.beGoodAt = beGoodAt;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransferRequire() {
        return transferRequire;
    }

    public void setTransferRequire(String transferRequire) {
        this.transferRequire = transferRequire;
    }

    public String getObserveAgreement() {
        return observeAgreement;
    }

    public void setObserveAgreement(String observeAgreement) {
        this.observeAgreement = observeAgreement;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanphone() {
        return linkmanphone;
    }

    public void setLinkmanphone(String linkmanphone) {
        this.linkmanphone = linkmanphone;
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(Integer matchNum) {
        this.matchNum = matchNum;
    }

    public Integer getWinNum() {
        return winNum;
    }

    public void setWinNum(Integer winNum) {
        this.winNum = winNum;
    }

    public Integer getKoNum() {
        return koNum;
    }

    public void setKoNum(Integer koNum) {
        this.koNum = koNum;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public int getAppointStatus() {
        return appointStatus;
    }

    public void setAppointStatus(int appointStatus) {
        this.appointStatus = appointStatus;
    }

    public String getAppointStartTime() {
        return appointStartTime;
    }

    public void setAppointStartTime(String appointStartTime) {
        this.appointStartTime = appointStartTime;
    }

    public int getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(int isTransfer) {
        this.isTransfer = isTransfer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
