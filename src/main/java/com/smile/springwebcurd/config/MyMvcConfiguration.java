package com.smile.springwebcurd.config;

import com.smile.springwebcurd.component.LoginHandlerInterceptor;
import com.smile.springwebcurd.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {
    /**
     * 视图控制器配置，将请求路径转发到相应html页面上
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
    }

    /**
     * 国际化配置
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/", "/index", "/user/login", "/asserts/**", "/webjars/**");
    }
}
