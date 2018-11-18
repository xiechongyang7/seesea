package com.seesea.seesealogin.config;

import com.seesea.seeseacommon.aspect.ControllerIntercept;
import com.seesea.seeseacommon.filter.ParamFilter;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import com.seesea.seeseacommon.token.TokenGenerate;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/11 下午 10:32
 * @Author xiechongyang
 */
@Configuration
public class AppConfig {

    @Value("${service.feign.connectTimeout:60000}")
    private int connectTimeout;

    @Value("${service.feign.readTimeOut:60000}")
    private int readTimeout;

    /**
     * 设置请求时间
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }
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
     * springcontext获取上下文对象
     * @return
     */
    @Bean(name = "SpringContextUtil")
    public SpringContextUtil getSpringContextUtil() {
        return new SpringContextUtil();
    }


    /**
     * springcontext获取上下文对象
     * @return
     */
    @Bean(name = "TokenGenerate")
    public TokenGenerate getTokenGenerate() {
        return new TokenGenerate();
    }
}
