package com.quanwei.myinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebInterceptorConfig extends WebMvcConfigurationSupport {
    /**
     * 定义拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHttpInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
