package com.seesea.seeseacommon.Assert;

import com.seesea.seeseacommon.Base.exception.BizException;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/26 下午 11:04
 * @Author xiechongyang
 */
public class Assert {


    public static void isNullStr(String str,String errCode, String errMsg) throws BizException {
        if("".equals(str)||str.length()==0){
            throw new BizException(errCode,errMsg);
        }
    }

    public static void isNull(Object obj,String errCode, String errMsg) throws BizException {
        if(obj==null||"".equals(obj)){
            throw new BizException(errCode,errMsg);
        }
    }

    public static  void  main(String ay[]) {
        System.out.println("qwe123" == null || "".equals("qwe"));
    }
}
