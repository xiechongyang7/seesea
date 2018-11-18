package com.seesea.seeseacommon.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;
import redis.clients.util.Pool;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/24 下午 9:00
 * @Author xiechongyang
 */
public class JedisPoolInit {

    private static final Logger logger = LoggerFactory.getLogger(JedisPoolInit.class);


    /**
     * 私有化构造器
     */
    private JedisPoolInit() {

    }
//    private static class RedisUtilHolder {
//        private static JedisPoolInit instance = new JedisPoolInit();
//    }
//
//    private static JedisPoolInit getInstance() {
//        return RedisUtilHolder.instance;
//    }
//
    private static Pool<Jedis> POOL;
    static {
        logger.info("初始化REDIS连接池");
        //连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(RedisConfig.REDIS_MAXTOTAL);
        config.setMaxIdle(RedisConfig.REDIS_MAXIDLE);
        config.setMinIdle(RedisConfig.REDIS_MINIDLE);
        config.setMaxWaitMillis(RedisConfig.REDIS_MAXWAIT);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        POOL = new JedisPool(config, RedisConfig.REDIS_HOST, Integer.valueOf(RedisConfig.REDIS_PORT), RedisConfig.REDIS_SOTIMEOUT, RedisConfig.REDIS_PASSWORD);
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = POOL.getResource();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 销毁对象
            if (jedis != null) {
                jedis.close();
            }
        }
        return jedis;
    }

    /**
     * 销毁实例
     *
     * @param jedis
     */
    public static void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
