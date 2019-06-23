package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.ItemFull;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsItemService;
import com.j1902.beststore.service.BsUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @Autowired
    private BsItemService bsItemService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(BsUser bsUser, Map<String, Object> map) {
        System.out.println("bsUser = [" + bsUser + "]");
        if (bsUserService.isExistBsUser(bsUser)) {
            return "register";
        }
        map.put("REGISTER_STATE", "fail");
        bsUserService.addBsUser(bsUser);
        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome() {
        return "home";
    }



}
