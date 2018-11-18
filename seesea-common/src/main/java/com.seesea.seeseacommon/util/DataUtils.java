//package com.seesea.seeseacommon.util;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Description
// * @Since JDK1.8
// * @Createtime 2018/10/26 下午 10:36
// * @Author xiechongyang
// */
//public class DateUtils {
//    /** 简化版日期字符串格式码 */
//    public static final String SIMPLE_FULLTIME = "yyyyMMddHHmmss";
//
//    /**
//     * 转换简化全时间描述文本为时间对象
//     *
//     * @param time 描述文本
//     * @return 时间对象，如果转换失败返回<code>null</code>
//     */
//    public static Date parseSimpleFullTime(String time) {
//        try {
//            return new SimpleDateFormat(SIMPLE_FULLTIME).parse(time);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//
//    /**
//     * 转换日志对象为简化全时间描述文本
//     *
//     * @param time 时间对象
//     * @return 描述文本
//     */
//    public static String toSimpleFullTimeStr(Date time) {
//        return new SimpleDateFormat(SIMPLE_FULLTIME).format(time);
//    }

//}
