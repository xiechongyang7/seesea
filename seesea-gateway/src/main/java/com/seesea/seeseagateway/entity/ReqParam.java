package com.seesea.seeseagateway.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 18:18 2018/9/13
 * @Author 谢重阳
 */
public class ReqParam {

    /**
     * 流水号
     */
    private String reqId;

    /**
     * 转发服务号
     */
    private String serviceId;

    /**
     * 请求时间
     */
    private Date reqTime;

    /**
     * 签名
     */
    private String sign;

    /**
     * 是否验签
     */
    @JsonProperty("isSign")
    private boolean isSign;

    /**
     * 是否验密
     */
    @JsonProperty("isEncrypt")
    private boolean isEncrypt;

    /**
     * 业务参数
     */
    private String data;

    /**
     * 用户id
     */
    private String userId;


    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(boolean encrypt) {
        isEncrypt = encrypt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
