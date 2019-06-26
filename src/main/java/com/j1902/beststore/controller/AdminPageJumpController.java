package com.j1902.beststore.controller;

import com.j1902.beststore.service.AdminBsItemService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:31
 */
@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminPageJumpController {

    @Autowired
    private AdminBsItemService itemService;

    @RequestMapping("/toAdminIndex.back")
    public String toAdminIndex(Map<String,Object> map){
        int itemsCount = itemService.getAllItems().size();
        map.put("ITEMS_COUNT", itemsCount);

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
