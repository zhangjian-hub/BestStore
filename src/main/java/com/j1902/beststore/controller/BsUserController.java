package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(BsUser bsUser){
        System.out.println("bsUser = [" + bsUser + "]");

        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome(){
        return "home";
    }
    @RequestMapping("/toChekout")
    public String toChekout(){
        return "checkout";
    }

}
