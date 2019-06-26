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
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session,HttpServletRequest req) {
        if(session.getAttribute("USER_INFO")!=null){
         req.setAttribute("respinfo","true");
            return "index";
        }
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(BsUser bsUser, HttpServletRequest request) {
        if (bsUserService.register(bsUser)) {
            request.setAttribute("REGISTER", "true");
            return "index";
        } else {
            request.setAttribute("REGISTER", "fail");
            return "register";
        }
    }

    @RequestMapping("/toIndex")
    public String toHome() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(BsUser bsUser, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws UnsupportedEncodingException {
        String remember = req.getParameter("remember");
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("loginInfo".equals(cookie.getName())) {
                    String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    bsUser = JsonUtils.jsonToPojo(decode, BsUser.class);
                }
            }
        }
        if (bsUserService.login(bsUser)) {
            if ("true".equals(remember)) {
                String s = JsonUtils.objectToJson(bsUser);
                String userEncode = URLEncoder.encode(s, "UTF-8");
                Cookie cookie = new Cookie("loginInfo", userEncode);
                cookie.setMaxAge(3600 * 24 * 30);
                resp.addCookie(cookie);
            }
            if (bsUser.getEmail().equals("15927147398@qq.com")) {
                bsUser.setPassword(null);
                return "admin/admin";
            }
            session.setAttribute("USER_INFO",bsUser);
            bsUser.setPassword(null);
            return "index";
        } else {
            req.setAttribute("LOGIN", "fail");
            return "login";
        }
    }

    @RequestMapping("/verity")
    @ResponseBody
    public boolean verity(String email) {
       if(bsUserService.verity(email)){
           return false;
       }else{
           return true;
       }
    };


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("USER_INFO");
        return  "login";
    }
}
