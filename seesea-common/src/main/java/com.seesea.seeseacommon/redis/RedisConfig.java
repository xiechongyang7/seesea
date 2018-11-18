package com.seesea.seeseacommon.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.util.Pool;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/24 下午 9:05
 * @Author xiechongyang
 */
public class RedisConfig {

    /**
     * 连接模式
     */
    public static String REDIS_MODE;

    @Value("${redis.mode}")
    private void setRedisMode(String redisMode) {
        this.REDIS_MODE = redisMode;
    }

    /**
     * 主机
     */
    public static String REDIS_HOST;

    @Value("${redis.host}")
    private void setRedisHost(String redisHost) {
        this.REDIS_HOST = redisHost;
    }


    /**
     * 端口
     */
    public static String REDIS_PORT;

    @Value("${redis.port}")
    private void setRedisPort(String redisPort) {
        this.REDIS_PORT = redisPort;
    }

    /**
     * 连接池最大数量
     */
    public static Integer REDIS_MAXTOTAL;

    @Value("${redis.maxtotal}")
    private void setREDIS_MAXTOTAL(Integer redisMaxtotal) {
        this.REDIS_MAXTOTAL = redisMaxtotal;
    }

    /**
     * 最大空闲连接数量
     */
    public static Integer REDIS_MAXIDLE;

    @Value("${redis.maxidle}")
    private void setREDIS_MAXIDLE(Integer redisMaxidle) {
        this.REDIS_MAXIDLE = redisMaxidle;
    }

    /**
     * 连接池最小空闲连接数量
     */
    public static Integer REDIS_MINIDLE;

    @Value("${redis.minidle}")
    private void setREDIS_MINIDLE(Integer redisMinidle) {
        this.REDIS_MINIDLE = redisMinidle;
    }

    /**
     * 获取连接池连接最长等待时间
     */
    public static Integer REDIS_MAXWAIT;

    @Value("${redis.maxwait}")
    private void setREDIS_MAXWAIT(Integer redisMaxwait) {
        this.REDIS_MAXWAIT = redisMaxwait;
    }

    /**
     * 读写超时时间设置
     */
    public static Integer REDIS_SOTIMEOUT;

    @Value("${redis.sotimeout}")
    private void setREDIS_SOTIMEOUT(Integer redisSotimeout) {
        this.REDIS_SOTIMEOUT = redisSotimeout;
    }

    /**
     * redis节点
     */
    public static String REDIS_NODES;

    @Value("${redis.nodes}")
    private void setREDIS_NODES(String redisNodes) {
        this.REDIS_NODES = redisNodes;
    }

    /**
     * redis名称
     */
    public static String REDIS_NAME;

    @Value("${redis.name}")
    private void setREDIS_NAME(String redisName) {
        this.REDIS_NAME = redisName;
    }

    /**
     * redis密码
     */
    public static String REDIS_PASSWORD;

    @Value("${redis.password}")
    private void setREDIS_PASSWORD(String redisPassword) {
        this.REDIS_PASSWORD = redisPassword;
    }

}
