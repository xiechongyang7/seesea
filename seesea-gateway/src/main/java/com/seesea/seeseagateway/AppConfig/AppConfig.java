package com.seesea.seeseagateway.AppConfig;

import com.seesea.seeseacommon.aspect.ControllerIntercept;
import com.seesea.seeseacommon.filter.ParamFilter;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import com.seesea.seeseacommon.token.TokenGenerate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/28 下午 10:43
 * @Author xiechongyang
 */
@Configuration
public class AppConfig {


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