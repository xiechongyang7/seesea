package com.seesea.seeseacommon.Base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.util.JsonUtil;

/**
 * @Description 所有请求vo都必须继承此类
 * @Since JDK1.8
 * @Createtime 2018/9/16 下午 4:00
 * @Author xiechongyang
 */
public class ReqVoCommon extends BaseModel{

    private String reqId;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @JsonIgnore
    public Result getResult(){
        Result result = new Result();
        result.setReqId(reqId);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg(ResultCode.SUCCESS_MSG);
        return result;
    }

}
