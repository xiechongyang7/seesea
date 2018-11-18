package com.seesea.seeseacommon.util;


import com.seesea.seeseacommon.util.date.DateUtils;

import java.util.Date;

/**
 * @Description id生成规则 业务id(2) + 简化时间(14) + 四位随机数(4) = id(20)
 * @Since JDK1.8
 * @Createtime 2018/10/26 下午 10:33
 * @Author xiechongyang
 */
public class IdGenerate {


    private static String userId = "11";
    private static String smsId = "12";
    private static String loginId = "14";
    private static String getFourRandom(){
        return String.valueOf((int)(Math.random()*9+1)*1000);
    }


    /**
     * 用户id
     * @return
     */
    public static String getUserId(){
        return getId(userId);
    }
    /**
     * 短信的id
     * @return
     */
    public static String getSmsId(){
        return getId(smsId);
    }
    /**
     * 登录id
     * @return
     */
    public static String getLoginId(){
        return getId(loginId);
    }

    private static String getId(String head){
        String data = DateUtils.toSimpleFullTimeStr(new Date());
        return head+data+getFourRandom();
    }
}
