package com.j1902.beststore.controller;

import com.j1902.beststore.modle.ShoppingCartResult;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsUserService;
import com.j1902.beststore.utils.JsonUtils;
import com.j1902.beststore.utils.UseUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session,HttpServletRequest req) {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public boolean register(BsUser bsUser, HttpServletRequest request) {
        String confirm_password = request.getParameter("confirm_password");
        if(bsUser.getEmail()==null ||bsUser.getPassword()==null ||bsUser.getNickname()==null ||bsUser.getPhone()==null||confirm_password==null||
            ""==bsUser.getEmail()|| ""==bsUser.getPassword()||""==bsUser.getNickname()||""==bsUser.getPhone()||""==confirm_password
        ){
            return false;
        }
        return bsUserService.register(bsUser);
    }

    @RequestMapping("/toIndex")
    public String toHome() {
        return "index";
    }
    @RequestMapping("/toAdmin")
    public String toAdmin() {
        return "admin/admin-index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(BsUser bsUser, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws UnsupportedEncodingException {
        if(bsUser.getEmail()==null||bsUser.getPassword()==null||""==bsUser.getEmail()||""==bsUser.getPassword()){
            return false;
        }
        String remember = req.getParameter("remember");
        if (bsUserService.login(bsUser,req)!=null ) {
            if ("true".equals(remember)) {
                String s = JsonUtils.objectToJson(bsUserService.login(bsUser,req));
                String userEncode = URLEncoder.encode(s, "UTF-8");
                Cookie cookie = new Cookie("loginInfo", userEncode);
                cookie.setMaxAge(3600 * 24 * 30);
                resp.addCookie(cookie);
            }
            session.setAttribute("USER_INFO",bsUserService.login(bsUser,req));
            bsUser.setPassword(null);
            return true;
        } else {
            return false;
        }
    }



    @RequestMapping("/verityEmail")
    @ResponseBody
    public boolean verityEmail(String email) {
       if(bsUserService.verityEmail(email)){
           return false;
       }else{
           return true;
       }
    };
    @RequestMapping("/verityPhone")
    @ResponseBody
    public boolean verityPhone(String phone) {
        if(bsUserService.verityPhone(phone)){
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

    @RequestMapping("/button")
    public String button(HttpServletRequest request){

        return  "login";
    }

}
