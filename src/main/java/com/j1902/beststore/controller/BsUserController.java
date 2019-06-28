package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsUserService;
import com.j1902.beststore.utils.JsonUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, HttpServletRequest req) {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(BsUser bsUser, HttpServletRequest request) {
        try {
            if (bsUserService.register(bsUser)) {
                request.setAttribute("REGISTER", "true");
                return "login";
            } else {
                request.setAttribute("REGISTER", "fail");
                return "register";
            }
        } catch (Exception e) {
            return "error/index";
        }
    }

    @RequestMapping("/toIndex")
    public String toHome() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(BsUser bsUser, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws UnsupportedEncodingException {
        try {
            String remember = req.getParameter("remember");
            if (bsUserService.login(bsUser, req) != null) {
                if ("true".equals(remember)) {
                    String s = JsonUtils.objectToJson(bsUserService.login(bsUser, req));
                    String userEncode = URLEncoder.encode(s, "UTF-8");
                    Cookie cookie = new Cookie("loginInfo", userEncode);
                    cookie.setMaxAge(3600 * 24 * 30);
                    resp.addCookie(cookie);
                }
                if (bsUser.getEmail().equals("15927147398@qq.com")) {
                    bsUser.setPassword(null);
                    session.setAttribute("ADMIN_USER_INFO", bsUserService.login(bsUser, req));
                    return "admin/admin-index";

                }
                session.setAttribute("USER_INFO", bsUserService.login(bsUser, req));
                bsUser.setPassword(null);
                return "redirect:/toIndex";
            } else {
                req.setAttribute("LOGIN", "fail");
                return "login";
            }
        } catch (Exception e) {
            return "error/index";
        }
    }

    @RequestMapping("/verityEmail")
    @ResponseBody
    public boolean verityEmail(String email) {
        if (bsUserService.verityEmail(email)) {
            return false;
        } else {
            return true;
        }
    }

    ;

    @RequestMapping("/verityPhone")
    @ResponseBody
    public boolean verityPhone(String phone) {
        if (bsUserService.verityPhone(phone)) {
            return false;
        } else {
            return true;
        }
    }

    ;


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USER_INFO");
        return "login";
    }
}
