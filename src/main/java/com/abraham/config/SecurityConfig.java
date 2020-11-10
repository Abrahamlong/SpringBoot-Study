//package com.abraham.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author long
// * @date 2020/11/10
// */
////@EnableWebSecurity  // 注解开启Security
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    // 定义授权规则
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 首页所有人可以访问，功能页只有对应有权限的人才能访问
//        // 请求授权的规则
////        http.authorizeRequests().antMatchers("/").permitAll()
////                .antMatchers("/level1/**").hasRole("vip1")
////                .antMatchers("/level2/**").hasRole("vip2")
////                .antMatchers("/level3/**").hasRole("vip3");
////        super.configure(http);
////
////        // 开启自动配置的登录功能，没有权限自动跳转到登录页面
////        // /login 请求来到登录页
////        // /login?error 重定向到这里表示登录失败
////        http.formLogin();
//    }
//
//    //定义认证规则
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //在内存中定义，也可以在jdbc中去拿( jdbcAuthentication() )
////        auth.inMemoryAuthentication()
////                .withUser("long").password("123456").roles("vip2","vip3")
////                .and()
////                .withUser("root").password("123456").roles("vip1","vip2","vip3")
////                .and()
////                .withUser("guest").password("123456").roles("vip1","vip2");
//    }
//
//}
