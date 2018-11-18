package com.seesea.seesealogin.model.vo;

import com.seesea.seeseacommon.Base.ReqVoCommon;
import com.seesea.seeseacommon.util.param.annotation.Allow;
import com.seesea.seeseacommon.util.param.annotation.NotNull;
import com.seesea.seeseacommon.util.param.annotation.TypeNumber;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/23 下午 11:49
 * @Author xiechongyang
 */
public class RegisterVo extends ReqVoCommon {

    @NotNull
    private String registerName;

    @NotNull
    private String pwd;

    @Allow(notNull = true,allows = {"phone","email","gitHub"})
    private String registerType;

    private String vcode;

    private String ip;

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
