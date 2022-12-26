package com.mingming.config;

import com.mingming.controller.Interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author h
 */
@Configuration
@ComponentScan({"com.mingming.controller", "com.mingming.config"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/users");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 当访问到/pages/???的时候不交给SpringMvc处理，交给Tomcat
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
