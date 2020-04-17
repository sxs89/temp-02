package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){

        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("logUser",username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户或密码错误");
            return "login";
        }
    }
}
