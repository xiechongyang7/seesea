//package com.seesea.seeseacommon.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.*;
//import redis.clients.util.Pool;
//
//import java.util.*;
//
///**
// * @Description
// * @Since JDK1.8
// * @Createtime 2018/10/24 下午 9:00
// * @Author xiechongyang
// */
//public class JedisPoolInit1 {
//
//    private static final Logger logger = LoggerFactory.getLogger(JedisPoolInit.class);
//
//
//    /**
//     * 私有化构造器
//     */
//    private JedisPoolInit() {
//
//    }
//
//    static Pool<Jedis> POOL;
////    static JedisCluster JEDISCLUSTER = null;
//
//    static {
//        logger.info("初始化REDIS连接池--开始");
//        getPool();
//        logger.info("初始化REDIS连接池--完成");
//    }
//
//    private static void getPool() {
//        logger.info("初始化REDIS连接池");
//        try {
//            //连接池配置
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(RedisConfig.REDIS_MAXTOTAL);
//            config.setMaxIdle(RedisConfig.REDIS_MAXIDLE);
//            config.setMinIdle(RedisConfig.REDIS_MINIDLE);
//            config.setMaxWaitMillis(RedisConfig.REDIS_MAXWAIT);
//            config.setTestOnBorrow(true);
//            config.setTestOnReturn(true);
//            //判断是否需要密码
//            boolean nullPwd = RedisConfig.REDIS_PASSWORD == null || "".equals(RedisConfig.REDIS_PASSWORD);
//            switch (RedisConfig.REDIS_MODE) {
//                //单机模式
//                case "standalone":
//                    logger.info("初始化REDIS连接池standalone");
//                    String[] hostAndPort = HostAndPort.extractParts(RedisConfig.REDIS_NODES);
//                    if (nullPwd) {
//                        POOL = new  JedisPool(config, RedisConfig.REDIS_HOST, Integer.valueOf(RedisConfig.REDIS_PORT), RedisConfig.REDIS_SOTIMEOUT, RedisConfig.REDIS_PASSWORD);
//
////                    POOL = new JedisPool(config, hostAndPort[0], Integer.valueOf(hostAndPort[1]), RedisConfig.REDIS_SOTIMEOUT, false);
////                    new  JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password)
////                    POOL = new JedisPool(config, hostAndPort[0], Integer.valueOf(hostAndPort[1]), RedisConfig.REDIS_SOTIMEOUT, false);
//                    } else {
//                        POOL = new  JedisPool(config, RedisConfig.REDIS_HOST, Integer.valueOf(RedisConfig.REDIS_PORT), RedisConfig.REDIS_SOTIMEOUT, RedisConfig.REDIS_PASSWORD);
//
////                    POOL = new JedisPool(config, hostAndPort[0], Integer.valueOf(hostAndPort[1]), RedisConfig.REDIS_SOTIMEOUT, RedisConfig.REDIS_PASSWORD);
//                    }
//                    break;
//                //哨兵模式
//                case "sentinel":
//                    logger.info("初始化REDIS连接池sentinel");
//                    Set<String> sentinels = new HashSet<String>();
//                    for (String node : RedisConfig.REDIS_NODES.split(",")) {
//                        sentinels.add(node);
//                    }
//                    if (nullPwd) {
//                        POOL = new JedisSentinelPool(RedisConfig.REDIS_NAME, sentinels, config, RedisConfig.REDIS_SOTIMEOUT);
//                    } else {
//                        POOL = new JedisSentinelPool(RedisConfig.REDIS_NAME, sentinels, config, RedisConfig.REDIS_SOTIMEOUT, RedisConfig.REDIS_PASSWORD);
//                    }
//                    break;
////            //集群模式
////            case "cluster":
////                logger.info("初始化REDIS连接池cluster");
////                Set<HostAndPort> hostAndPorts = new LinkedHashSet<HostAndPort>();
////                for (String node : RedisConfig.REDIS_NODES.split(",")) {
////                    hostAndPorts.add(HostAndPort.parseString(node));
////                }
////                if (nullPwd) {
////                    JEDISCLUSTER = new JedisCluster(hostAndPorts, RedisConfig.REDIS_MAXWAIT, RedisConfig.REDIS_SOTIMEOUT, 1, config);
////                } else {
////                    JEDISCLUSTER = new JedisCluster(hostAndPorts, RedisConfig.REDIS_MAXWAIT, RedisConfig.REDIS_SOTIMEOUT, 1, RedisConfig.REDIS_PASSWORD, config);
////                }
////                break;
//            }
//        }catch (Exception e){
//            logger.info("初始化redis连接池错误",e);
//        }
//
//    }
//
//    /**
//     * 获取实例
//     *
//     * @return
//     */
//    public static Jedis getJedis() {
//        Jedis jedis = null;
//        try {
//            jedis = POOL.getResource();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            // 销毁对象
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//        return jedis;
//    }
//
//    /**
//     * 销毁实例
//     *
//     * @param jedis
//     */
//    public static void closeJedis(Jedis jedis) {
//        if (jedis != null) {
//            jedis.close();
//        }
//    }
//}
