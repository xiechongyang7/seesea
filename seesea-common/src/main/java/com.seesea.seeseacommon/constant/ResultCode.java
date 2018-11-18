package com.seesea.seeseacommon.constant;

/**
 * @Description 返回信息 异常信息
 * @Since JDK1.8
 * @Createtime 2018/9/14 下午 11:40
 * @Author xiechongyang
 */
public class ResultCode {


    /**
     * 成功
     */
    public static String SUCCESS = "200";
    public static String SUCCESS_MSG = "success";

    /**
     * 异常
     */
    public static String ERR = "9999";
    public static String ERR_MSG = "服务器异常[%s]";

    public static String ER_9000 = "ER_9000";
    public static String ER_9000_MSG = "参数有误空指针异常";

    public static String ER_9001 = "9001";
    public static String ER_9001_MSG = "未知异常";

    public static String ER_9002 = "9002";
    public static String ER_9002_MSG = "参数有误空数据库操作异常";

    public static String ER_9003 = "9003";
    public static String ER_9003_MSG = "参数错误[%s]";
    /**
     * =====================================================网关错误码 10 start=====================================================
     */

    public static String ER_1000 = "1000";
    public static String ER_1000_MSG = "流水号重复";

    public static String ER_1001 = "1001";
    public static String ER_1001_MSG = "网关验签失败";

    public static String ER_1002 = "1002";
    public static String ER_1002_MSG = "网关鉴权失败";

    public static String ER_1003 = "1003";
    public static String ER_1003_MSG = "网关处理异常";

    public static String ER_1004 = "1004";
    public static String ER_1004_MSG = "服务返回参数处理错误";

    public static String ER_1005 = "1005";
    public static String ER_1005_MSG = "服务ID错误";

    public static String ER_1006 = "1006";
    public static String ER_1006_MSG = "请求流水号或服务ID不能为空";
    /** =====================================================网关错误码 10 end===================================================== */


    /**
     * =====================================================登录错误码 11 start=====================================================
     */

    public static String ER_1104 = "1104";
    public static String ER_1104_MSG = "已存在用户";
    public static String ER_1105 = "1105";
    public static String ER_1105_MSG = "不存在用户";
    public static String ER_1106 = "1106";
    public static String ER_1106_MSG = "密码错误";
    public static String ER_1107 = "1107";
    public static String ER_1107_MSG = "请去邮箱点击验证链接";
    public static String ER_1108 = "1108";
    public static String ER_1108_MSG = "github返回信息为空";
    public static String ER_1109 = "1109";
    public static String ER_1109_MSG = "验证码错误";

    /** =====================================================登录错误码 11 end===================================================== */


    /**
     * =====================================================短信服务错误码 12 start=====================================================
     */

    public static String ER_1200 = "1200";
    public static String ER_1200_MSG = "该短信不支持此方法";

    public static String ER_1201 = "1201";
    public static String ER_1201_MSG = "短信已经发送请稍后再试";

    public static String ER_1202 = "1202";
    public static String ER_1202_MSG = "无可用的短信通道";

    public static String ER_1203 = "1203";
    public static String ER_1203_MSG = "发送短信参数转化异常";

    public static String ER_1204 = "1204";
    public static String ER_1204_MSG = "短信通道没有返回信息";

    public static String ER_1205 = "1205";
    public static String ER_1205_MSG = "短信通道没有返回有效信息";

    public static String ER_1206 = "1206";
    public static String ER_1206_MSG = "一天只能发送[%s]次";

    public static String ER_1207 = "1207";
    public static String ER_1207_MSG = "您还未发送验证码短信";

    public static String ER_1208 = "1208";
    public static String ER_1208_MSG = "验证码错误(校验短信次数超过[%s],此短信失效)";

    public static String ER_1209 = "1209";
    public static String ER_1209_MSG = "验证码短信过期";

    public static String ER_1210 = "1210";
    public static String ER_1210_MSG = "验证码错误";
    /** =====================================================短信服务错误码 12 end===================================================== */

}
