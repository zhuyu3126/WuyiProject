package com.danmo.commonapi.bean.home;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
/*
* 新闻详情
* */
public class NewsInfo extends BaseItem implements Serializable {

    int newsId; /**  新闻Id*/
    String title;/** 新闻标题 */
    String icoUrlString; /** 图片路径 */
    int  readNum; /** 阅读数 */
    int newsType; /** 新闻类型 */
    String contentAbstract; /** 新闻内容 */
    String publicDate; /** 发布时间 */
    String isUse; /** 是否有效 */
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcoUrlString() {
        return icoUrlString;
    }

    public void setIcoUrlString(String icoUrlString) {
        this.icoUrlString = icoUrlString;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public String getContentAbstract() {
        return contentAbstract;
    }

    public void setContentAbstract(String contentAbstract) {
        this.contentAbstract = contentAbstract;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}
