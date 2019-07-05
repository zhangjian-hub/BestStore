//package com.j1902.beststore.config;
//
//import com.j1902.beststore.interceptor.AutoLogin;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        AutoLogin testHandlerInterceptor = new AutoLogin();
//        registry.addInterceptor(testHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/**/*.css",
//                "/**/*.js", "/**/*.png", "/**/*.jpg",
//                "/**/*.jpeg", "/**/*.gif", "/**/fonts/*");
//    }
//}