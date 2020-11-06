package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/3
 */
//在templates目录下的缩影界面只能通过controller来跳转
//这个需要模板引擎的支持：thymeleaf
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","hello thymeleaf");
        model.addAttribute("users", Arrays.asList("long","abraham","longjian"));
        return "index";
    }
}
