package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.User;
import com.j1902.beststore.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome(User user){
        System.out.println("user = " + user);
        if (user == null) {
            return "login";
        }
        if (userService.login(user)) {
            return "home";
        }
        return "login";
    }
}
