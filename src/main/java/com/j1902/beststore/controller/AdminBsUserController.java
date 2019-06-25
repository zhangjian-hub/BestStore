package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminBsUserController {

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
    public String register(BsUser bsUser, Map<String,Object> map){
        System.out.println("bsUser = [" + bsUser + "]");
        if (bsUserService.isExistBsUser(bsUser)) {
            return "register";
        }
        map.put("REGISTER_STATE", "fail");
        bsUserService.addBsUser(bsUser);
        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome(){
        return "home";
    }

    @RequestMapping("/toCheckout")
    public String toCheckout(){
        return "checkout";
    }

}
