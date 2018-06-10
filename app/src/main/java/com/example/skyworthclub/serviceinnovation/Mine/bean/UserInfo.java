package com.example.skyworthclub.serviceinnovation.Mine.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dn on 2018/6/10.
 */

public class UserInfo {
    @SerializedName("isSuccessful")
    private boolean issuccessful;
    @SerializedName("errorMessage")
    private String errormessage;
    @SerializedName("userId")
    private int userid;
    @SerializedName("userName")
    private String username;


    public void setIssuccessful(boolean issuccessful) {
        this.issuccessful = issuccessful;
    }
    public boolean getIssuccessful() {
        return issuccessful;
    }


    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
    public String getErrormessage() {
        return errormessage;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getUserid() {
        return userid;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

}
