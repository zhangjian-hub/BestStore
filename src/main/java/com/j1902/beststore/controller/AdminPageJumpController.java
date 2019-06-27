package com.j1902.beststore.controller;

import com.j1902.beststore.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private AdminBsOrderFormService orderFormService;

    @RequestMapping("/toAdminIndex.back")
    public String toAdminIndex(Map<String,Object> map){
        int itemsCount = itemService.getAllItems().size();
        map.put("ITEMS_COUNT", itemsCount);
        int usersCount = userService.getCountOfBsUsers();
        map.put("USERS_COUNT", usersCount);
        int recordsCount = shoppingRecordService.getCountOfAll();
        map.put("RECORDS_COUNT", recordsCount);
        int emailsCount = emailService.getCountOfAllEmails();
        map.put("EMAILS_COUNT", emailsCount);
        return "admin/admin-index";
    }

    @RequestMapping("/toOrderForm.back")
    public String toOrderForm(Map<String,Object> map, @RequestParam(defaultValue = "1")int pageSum, @RequestParam(defaultValue = "10")int pageSize){
        map.put("ALL_ORDER_FORMS",orderFormService.getAllOrderForms(pageSum,pageSize));
        return "admin/order-form";
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
