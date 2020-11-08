package com.abraham.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/3
 */
// 扩展SpringMVC
@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/long ， 就会跳转到long页面；
        registry.addViewController("/long").setViewName("long");
    }

    //    @Bean // 放到Bean中，SpringBoot就会帮我们自动装配
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    // 只要是实现了视图解析器接口（ViewResolver）的类都可以将其看成视图解析器
//    // 我们写一个静态内部类，自定义实现自己的视图解析器，实现ViewResolver接口
//    private static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
}
