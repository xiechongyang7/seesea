package com.seesea.seeseasms.config;

import com.seesea.seeseacommon.aspect.ControllerIntercept;
import com.seesea.seeseacommon.filter.ParamFilter;
import com.seesea.seeseacommon.redis.RedisConfig;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/28 下午 9:31
 * @Author xiechongyang
 */
@Configuration
public class AppConfig {


    /**
     * 注入请求参数类型拦截器
     * @return
     */
    @Bean(name = "ParamFilter")
    public ParamFilter getParamFilter() {
        return new ParamFilter();
    }

    /**
     * 注入参数拦截器
     * @return
     */

    @Bean(name = "ControllerIntercept")
    public ControllerIntercept getControllerIntercept() {
        return new ControllerIntercept();
    }

    /**
     * redis 配置
     * @return
     */
    @Bean(name = "redisConfig")
    public RedisConfig getRedisConfig() {
        return new RedisConfig();
    }

    /**
     * springContextUtil
     * @return
     */
    @Bean(name = "SpringContextUtil")
    public SpringContextUtil getSpringContextUtil() {
        return new SpringContextUtil();
    }

}
