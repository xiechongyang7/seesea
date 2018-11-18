package com.seesea.seeseacommon.Base.exception;

/**
 * @Description 业务异常异常
 * @Since JDK1.8
 * @Createtime 2018/9/16 下午 5:29
 * @Author xiechongyang
 */
public class BizException extends Exception{

    public String errCode;
//    public String errMsg;

    public BizException(){
        super();
    }

    public BizException(BizException e){
        super(e.getMessage());
//        this.errMsg = errMsg;
        this.errCode = e.errCode;
    }

    public BizException(String errCode,String errMsg){
        super(errMsg);
//        this.errMsg = errMsg;
        this.errCode = errCode;
    }
}
