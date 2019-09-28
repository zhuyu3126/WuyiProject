package com.danmo.commonapi.bean.home.club;

import com.danmo.commonapi.bean.BaseItem;

public class ClubMember extends BaseItem {
    /** 俱乐部成员ID */
    private int mbId;
    /** 所属俱乐部 */
    private int clubId;
    /** 用户ID */
    private Long userId;
    /** 成员名字 */
    private String name;
    /** 绰号 */
    private String nickname;
    /** 联系电话 */
    private String linkphone;
    /** 身份证号码 */
    private String idcardno;
    /** 身份证正面 */
    private String idFront;
    /** 身份证反面 */
    private String idBack;
    /** 性别 */
    private String sex;
    /** 年龄 */
    private int age;
    /** 身高 */
    private int height;
    /** 体重 */
    private int weight;
    /** 出生年月日 */
    private String birthday;
    /** 籍贯 */
    private String nativeplace;
    /** 成员照片（个人海报） */
    private String photo;
    /** 介绍视频地址 */
    private String video;
    /** 介绍视频的图片地址 */
    private String videoPhoto;
    /** 参加比赛次数 */
    private int matchNum;
    /** 获胜次数 */
    private int winNum;
    /** ko次数 */
    private int koNum;
    /** 最佳战绩 */
    private String bestRecord;
    /** 级别(重量级) */
    private int level;
    /** 评分 */
    private Double scoreNum;
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
    /** 教育程度:1,middle,初中;2,higer,高中;3,diploma,大专;4,undergraduate,本科，5,graduate 研究生 */
    private int education;
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
    /** 紧急联系人 */
    private String linkman1;
    /** 紧急联系人电话 */
    private String linkmanphone1;
    /** 是否参加比赛:1,join,参加;2,not_join,不参加 */
    private int isJoinMatch;
    /** 是否转会： 0-否； 1-是 */
    private int isTransfer;
    /** 状态 0-无效 ；1-有效 */
    private int status;
    private int isStar;//是否是明星 0：否 1：是
    public int getIsStar() {
        return isStar;
    }

    public void setIsStar(int isStar) {
        this.isStar = isStar;
    }

    public int getMbId() {
        return mbId;
    }

    public void setMbId(int mbId) {
        this.mbId = mbId;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoPhoto() {
        return videoPhoto;
    }

    public void setVideoPhoto(String videoPhoto) {
        this.videoPhoto = videoPhoto;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public int getWinNum() {
        return winNum;
    }

    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    public int getKoNum() {
        return koNum;
    }

    public void setKoNum(int koNum) {
        this.koNum = koNum;
    }

    public String getBestRecord() {
        return bestRecord;
    }

    public void setBestRecord(String bestRecord) {
        this.bestRecord = bestRecord;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
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

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
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

    public String getLinkman1() {
        return linkman1;
    }

    public void setLinkman1(String linkman1) {
        this.linkman1 = linkman1;
    }

    public String getLinkmanphone1() {
        return linkmanphone1;
    }

    public void setLinkmanphone1(String linkmanphone1) {
        this.linkmanphone1 = linkmanphone1;
    }

    public int getIsJoinMatch() {
        return isJoinMatch;
    }

    public void setIsJoinMatch(int isJoinMatch) {
        this.isJoinMatch = isJoinMatch;
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
}
