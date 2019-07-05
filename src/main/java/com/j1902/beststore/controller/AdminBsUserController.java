package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.AdminBsUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zj
 * @version 1.0
 * @create 2019-07-05 19:21
 */

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminBsUserController {
    @Autowired
    private AdminBsUserService userService;

    @RequestMapping("/updateUser.back")
    public String deleteItem(BsUser user, HttpSession session) {
        try {
            System.out.println("user = [" + user + "]");
            userService.setBsUSer(user);
            session.setAttribute("USER_INFO",user);
            return "redirect:/toAdminIndex.back";
        } catch (Exception e) {
            return "error/index";
        }
    }
}
