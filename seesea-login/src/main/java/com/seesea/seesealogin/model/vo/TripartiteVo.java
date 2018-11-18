package com.seesea.seesealogin.model.vo;

import com.seesea.seeseacommon.Base.ReqVoCommon;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/5 下午 10:37
 * @Author xiechongyang
 */
public class TripartiteVo extends ReqVoCommon {

    private String type;

    private String authCode;

    public String getType() {
        return type;
    }

    public String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "TripartiteVo{" +
                "type='" + type + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }
}
