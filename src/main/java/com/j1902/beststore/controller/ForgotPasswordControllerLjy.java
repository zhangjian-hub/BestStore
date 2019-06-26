package com.j1902.beststore.controller;

import com.j1902.beststore.modle.State;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.ForgotPasswordServiceLjy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.com.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class ForgotPasswordControllerLjy {

    @Autowired
    private ForgotPasswordServiceLjy forgotPasswordService;

    public Utils utils = new Utils();

    @RequestMapping("/toForgotPassword.html")
    public String toForgotPassword() {
        return "forgotPassword";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("/toLogin.html")
    public String toLogin() {
        return "login";
    }
    @RequestMapping("/toForgotPassword")
    @ResponseBody
    public State forgotPassword(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        System.out.println("email = " + email);
        String phone1 = req.getParameter("phone");
        String password = req.getParameter("password");
        System.out.println("password = " + password);
        BsUser bsUser = new BsUser();
        bsUser.setPassword(password);
        List<String> list = forgotPasswordService.selectBsUserid(email);
        Integer id = Integer.valueOf(list.get(0));
        System.out.println("id = " + id);
        String phone = list.get(1);
        bsUser.setId(id);
        State state = new State();
        System.out.println("xx = " );
        if(phone.equals(phone1)){
            if(forgotPasswordService.ForgotPassword(bsUser)){
                System.out.println("111");
                state.setState(true);
                System.out.println("state = " + state);
                return state;
            }else {
                state.setState(false);
                return state;
            }
        }else {
            state.setState(false);
            return state;
        }



    }
}
