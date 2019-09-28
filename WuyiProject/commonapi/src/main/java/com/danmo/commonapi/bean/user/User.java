package com.danmo.commonapi.bean.user;

import java.io.Serializable;
/*
* 用户实体
* */
public class User implements Serializable {
    String id;//用户id
    String userName; //用户账号
    String passWord;//密码
    String tel;//联系电话
    String fstLogin;//Y/是否第一次登录
    String acctId;//所属经销商
    String fstName;//用户名称

    public String getFstName() {
        return fstName;
    }

    public void setFstName(String fstName) {
        this.fstName = fstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getFstLogin() {
        return fstLogin;
    }

    public void setFstLogin(String fstLogin) {
        this.fstLogin = fstLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
