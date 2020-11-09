package com.abraham.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 处理可以在链接上携带区域信息
 * @author long
 * @date 2020/11/9
 */
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 去获取请求中的语言参数
        String language = request.getParameter("lang");
        Locale locale = Locale.getDefault(); // 如果没有获取到就使用系统默认的
        // 如果请求的链接参数“lang”不为空
        if (!StringUtils.isEmpty(language)){
            // 分割请求参数 zh_CN  en_US
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
