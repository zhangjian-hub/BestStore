package com.j1902.beststore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.BsEmailService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-25 14:08
 */
@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminBsEmailController {
    @Autowired
    private BsEmailService emailService;

    @RequestMapping("/toAdminEmail.back")
    public String toAdminEmail(Map<String,Object> map, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BsEmail> emails = emailService.getAllEmails();
        System.out.println(emails.get(0));
        System.out.println("emails1 = " + emails);
        PageInfo<BsEmail> pageInfo = new PageInfo<>(emails);
        System.out.println("pageInfo = " + pageInfo);
        map.put("ALL_EMAILS", pageInfo);
        BsEmail bsEmail = emailService.selectById(4);
        System.out.println("bsEmail1 = " + bsEmail);
        return "admin/admin-email";
    }
}
