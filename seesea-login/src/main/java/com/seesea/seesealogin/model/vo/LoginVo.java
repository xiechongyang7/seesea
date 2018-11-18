package com.seesea.seesealogin.model.vo;

import com.seesea.seeseacommon.Base.ReqVoCommon;
import com.seesea.seeseacommon.util.param.annotation.NotNull;
import com.seesea.seeseacommon.util.param.annotation.TypeNumber;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/2 下午 5:26
 * @Author xiechongyang
 */
public class LoginVo extends ReqVoCommon {

    @NotNull
    private String logName;

    @NotNull
    private String pwd;

    private String Ip;
    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }
}
