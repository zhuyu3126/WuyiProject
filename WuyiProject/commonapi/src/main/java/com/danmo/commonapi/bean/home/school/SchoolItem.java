package com.danmo.commonapi.bean.home.school;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;

public class SchoolItem extends BaseItem implements Serializable {
    private int schoolId;
    /** 武校名称 */
    private String name;
    /** 营业执照 */
    private String businessLicense;
    /** 武校法人用户 */
    private int userId;
    /** 身份证正面 */
    private String idFront;
    /** 身份证反面 */
    private String idBack;
    /** 地区Id */
    private int districtsId;
    /** 地址 */
    private String address;
    /** 客服电话 */
    private int customerServicePhone;
    /** 联系人 */
    private String linkman;
    /** 联系电话 */
    private String linkphone;
    /** 学校图片 */
    private String photo;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 介绍视频地址 */
    private String video;
    /** 招生简章图 */
    private String admissionsProfilePicture;
    /** 招生简章 */
    private String admissionsProfile;
    /** 评论个数 */
    private int commentsNum;
    /** 收藏个数 */
    private int collectionNum;
    /** 关注个数 */
    private int focusNum;
    /** 点赞数 */
    private int favorNum;
    /** 浏览数 */
    private int visitNum;
    /** 招聘教练协议 */
    private String recruitCoachAgreement;
    /** 状态 0-无效 ；1-有效 */
    private int status;


    /** 点赞状态 0-已点赞；1-未点赞*/
    private int favorStatus;
    /** 收藏状态 0-已收藏；1-未收藏*/
    private int collectStatus;
    /** 关注状态 0-已关注；1-未关注*/
    private int focusStatus;
    /** 地区名称 */
    private String districtsName;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public int getDistrictsId() {
        return districtsId;
    }

    public void setDistrictsId(int districtsId) {
        this.districtsId = districtsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAdmissionsProfilePicture() {
        return admissionsProfilePicture;
    }

    public void setAdmissionsProfilePicture(String admissionsProfilePicture) {
        this.admissionsProfilePicture = admissionsProfilePicture;
    }

    public String getAdmissionsProfile() {
        return admissionsProfile;
    }

    public void setAdmissionsProfile(String admissionsProfile) {
        this.admissionsProfile = admissionsProfile;
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

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public String getRecruitCoachAgreement() {
        return recruitCoachAgreement;
    }

    public void setRecruitCoachAgreement(String recruitCoachAgreement) {
        this.recruitCoachAgreement = recruitCoachAgreement;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getFocusStatus() {
        return focusStatus;
    }

    public void setFocusStatus(int focusStatus) {
        this.focusStatus = focusStatus;
    }

    public String getDistrictsName() {
        return districtsName;
    }

    public void setDistrictsName(String districtsName) {
        this.districtsName = districtsName;
    }
}
