package com.danmo.commonapi.bean.home.club;

import com.danmo.commonapi.bean.BaseItem;

import java.io.Serializable;
import java.math.BigDecimal;
/*
* VIP卡
* */
public class VipCardItem extends BaseItem implements Serializable {

    /** id */
    private int id;
    /** 商家类型:1,school,学校;2,gym,健身房;3,club,俱乐部 */
    private int businessType;
    /** 商家id */
    private int businessId;
    /** 会员卡名字 */
    private String cardName;
    /** 会员卡图 */
    private String cardImage;
    /** 价格 */
    private BigDecimal price;
    /** 状态 0-无效 ；1-有效 */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
