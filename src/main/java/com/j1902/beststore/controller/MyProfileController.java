package com.j1902.beststore.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class MyProfileController {

    @RequestMapping("/toMyProfile")
    public String toMyProfile() {

        return "myProfile";
    }
}
