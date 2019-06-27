package com.j1902.beststore.controller;

import com.j1902.beststore.service.AdminBsEmailService;
import com.j1902.beststore.service.AdminBsItemService;
import com.j1902.beststore.service.AdminBsShoppingRecordService;
import com.j1902.beststore.service.AdminBsUserService;
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

    @Autowired
    private AdminBsUserService userService;

    @Autowired
    private AdminBsShoppingRecordService shoppingRecordService;

    @Autowired
    private AdminBsEmailService emailService;

    @RequestMapping("/toAdminIndex.back")
    public String toAdminIndex(Map<String,Object> map){
        int itemsCount = itemService.getAllItems().size();
        System.out.println("itemsCount = " + itemsCount);
        map.put("ITEMS_COUNT", itemsCount);
        int usersCount = userService.getCountOfBsUsers();
        System.out.println("usersCount = " + usersCount);
        map.put("USERS_COUNT", usersCount);
        int recordsCount = shoppingRecordService.getCountOfAll();
        System.out.println("recordsCount = " + recordsCount);
        map.put("RECORDS_COUNT", recordsCount);
        int emailsCount = emailService.getCountOfAllEmails();
        System.out.println("emailsCount = " + emailsCount);
        map.put("EMAILS_COUNT", emailsCount);
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

    @RequestMapping("/toEmail")
    public String toEmail(){
        return "email";
    }

    @RequestMapping("/toShortCodes")
    public String toShortCodes(){
        return "short-codes";
    }
}
