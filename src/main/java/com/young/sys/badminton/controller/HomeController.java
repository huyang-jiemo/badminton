package com.young.sys.badminton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyang8
 * // TODO: 2018/10/8  首页controller
 */
@Controller
@RequestMapping("")
public class HomeController {

    /**
     * 登录页
     */
    @RequestMapping("/login.do")
    public String login(){
        return "/home/login";
    }


}
