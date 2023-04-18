package com.softuni.tennis_players.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Autowired
//    private MyFirstInterceptor myFirstInterceptor;
//
//    @Autowired
//    private MySecondInterceptor mySecondInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myFirstInterceptor)
//                .addPathPatterns("/path1/**", "/path2/**");
//        registry.addInterceptor(mySecondInterceptor)
//                .addPathPatterns("/path3/**", "/path4/**");
//    }
}
