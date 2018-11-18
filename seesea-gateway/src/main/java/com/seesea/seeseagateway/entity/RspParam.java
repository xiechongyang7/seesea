package com.seesea.seeseagateway.entity;

import java.util.Date;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 16:33 2018/9/14
 * @Author 谢重阳
 */
public class RspParam {

    private String code;

    private String msg;

    private String data;

    private Date rspTime;

    private String reqId;

    public Date getRspTime() {
        return rspTime;
    }

    public void setRspTime(Date rspTime) {
        this.rspTime = rspTime;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
