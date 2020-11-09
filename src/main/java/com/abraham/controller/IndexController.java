package com.abraham.controller;

import org.springframework.stereotype.Controller;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/3
 */
//在templates目录下的所有界面只能通过controller来跳转
//这个需要模板引擎的支持：thymeleaf
@Controller
public class IndexController {
//    @RequestMapping({"/","index.html"})
//    public String index(Model model){
//
//        return "index";
//    }
}
