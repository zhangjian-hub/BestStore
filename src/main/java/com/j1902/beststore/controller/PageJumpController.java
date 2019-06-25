package com.j1902.beststore.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:31
 */
@Controller
@MapperScan("com.j1902.beststore.mapper")
public class PageJumpController {

    @RequestMapping("/toAdminIndex.back")
    public String toAdminIndex(){
        return "admin/admin-index";
    }

    @RequestMapping("/toAdminAddItem.back")
    public String toAdminAddItem(){
        return "admin/admin-add-item";
    }

    @RequestMapping("/toAdminUser.back")
    public String toAdminUser(){
        return "admin/admin-user";
    }
}
