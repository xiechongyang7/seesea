package com.seesea.seeseauser.config;

import com.seesea.seeseacommon.aspect.ControllerIntercept;
import com.seesea.seeseacommon.filter.ParamFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/11 下午 10:44
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
}
