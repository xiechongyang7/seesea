package com.seesea.seeseagateway.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/11 下午 10:32
 * @Author xiechongyang
 */
@Configuration
public class WebAppConfiguer extends WebMvcConfigurationSupport {

//    @Autowired
//    private CrossInterceptor crossInterceptor;
    // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
    // excludePathPatterns 用户排除拦截
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(crossInterceptor).addPathPatterns("/**");
////        registry.addInterceptor(new AddressInterceptor()).addPathPatterns("/user/postUser");
//
////        super.addInterceptors(registry);
//    }

}

