package com.j1902.beststore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/home")
    @ResponseBody
    public String toHome(){
        return "hello";
    }
}
