package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author long
 * @date 2020/11/9
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session){
        // 具体的业务处理
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("LoginUser", username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "redirect:/index";
        }
    }
}
