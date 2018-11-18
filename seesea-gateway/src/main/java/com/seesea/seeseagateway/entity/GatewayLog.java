package com.seesea.seeseagateway.entity;

import java.util.Date;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/9/14 下午 11:27
 * @Author xiechongyang
 */
public class GatewayLog {

    private String reqId;

    private String reqParam;

    private String rspParam;

    private boolean isEncrypt;

    private boolean isSign;

    private String serviceId;

    private Date reqTime;

    private Date rspTime;

    private String rspCode;

    private String repMsg;

    private String userId;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getRspParam() {
        return rspParam;
    }

    public void setRspParam(String rspParam) {
        this.rspParam = rspParam;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(boolean encrypt) {
        isEncrypt = encrypt;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getRspTime() {
        return rspTime;
    }

    public void setRspTime(Date rspTime) {
        this.rspTime = rspTime;
    }

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
