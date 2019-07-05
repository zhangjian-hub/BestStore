package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.AdminBsEmailService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private AdminBsEmailService emailService;

    @RequestMapping("/toAdminEmail.back")
    public String toAdminEmail(Map<String,Object> map, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        try {
            PageInfo<BsEmail> pageInfo = emailService.getAllEmails(pageNum);
            map.put("ALL_EMAILS", pageInfo);
            return "admin/admin-email";
        } catch (Exception e) {
            return "error/index";
        }
    }
    @RequestMapping("/deleteEmail.back")
    public String deleteEmail(Integer id,@RequestParam(defaultValue = "1")int pageNum) {
        try {
            emailService.removeEmail(id);
            return "redirect:/toAdminEmail.back?pageNum=" + pageNum;
        } catch (Exception e) {
            return "error/index";
        }
    }
}
