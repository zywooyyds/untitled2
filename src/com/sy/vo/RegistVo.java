package com.sy.vo;

public class RegistVo {
    private String userName;
    private String userPwd;
    private String userPwdConfirm;

    public RegistVo() {
    }

    public RegistVo(String userName, String userPwd, String userPwdConfirm) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPwdConfirm = userPwdConfirm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwdConfirm() {
        return userPwdConfirm;
    }

    public void setUserPwdConfirm(String userPwdConfirm) {
        this.userPwdConfirm = userPwdConfirm;
    }
}
