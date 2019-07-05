package com.j1902.beststore.config;

/**
 * 资源映射路径
 * @author zj
 * @version 1.0
 * @create 2019-06-23 10:09
 */

import com.j1902.beststore.interceptor.AutoLogin;
import com.j1902.beststore.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:E:/temp-rainy/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/*.back");

        registry.addInterceptor(new AutoLogin()).addPathPatterns("/**").excludePathPatterns("/**/*.css",
                "/**/*.js", "/**/*.png", "/**/*.jpg",
                "/**/*.jpeg", "/**/*.gif", "/**/fonts/*");
    }
}
