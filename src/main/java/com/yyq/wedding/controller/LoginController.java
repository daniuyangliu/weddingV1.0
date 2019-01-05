package com.yyq.wedding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YangLiu
 * @Title: LoginController
 * @ProjectName wedding
 * @Description: TODO
 * @date 2019/1/411:13
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @RequestMapping("")
    public String login(){
        logger.info("==========进入登陆平台");
        return "login";
    }
}
