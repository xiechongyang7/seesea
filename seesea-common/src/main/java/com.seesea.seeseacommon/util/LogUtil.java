package com.seesea.seeseacommon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;

/**
 * @Description 日志工具类
 * @Since JDK1.8
 * @Createtime 16:58 2018/9/14
 * @Author 谢重阳
 */
public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * infor日志
     * @param reqId []
     * @param direct [描述]
     * @param logStr []
     */
    public static void logInfo(String reqId, String direct, String logStr) {
        MDC.put("REQID", reqId);// 日志分表
        logger.info(String.format("[%s] [%s] [%s]", reqId, direct, logStr));
    }

    /**
     * error日志
     * @param reqId
     * @param direct
     * @param logStr
     */
    public static void logError(String reqId, String direct, Exception logStr) {
        MDC.put("REQID", reqId);// 日志分表
        logger.error(String.format("[%s] [%s]", reqId, direct),logStr);
    }
}
