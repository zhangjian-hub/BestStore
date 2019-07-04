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

    @RequestMapping("/toIndex.html")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("/toLogin.html")
    public String toLogin() {
        return "login";
    }
    @RequestMapping("/toForgotPassword")
    @ResponseBody
    public State forgotPassword(HttpServletRequest req) {
        String email = req.getParameter("email");
        String phone1 = req.getParameter("phone");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        State state = new State();
        if (email!=null&&!"".equals(email)&&phone1!=null&&!"".equals(phone1)&&password1!=null&&!"".equals(password1)&&password2!=null&&!"".equals(password2)){
            System.out.println("password1.equals(password2) = " + password1.equals(password2));
            if((password1.equals(password2))&&(password1.length()<5||password1.length()>16)){
                state.setState(false);
                return state;
            }
            if(!(password1.equals(password2))){
                state.setState(false);
                return state;
            }
            BsUser bsUser = new BsUser();
            bsUser.setPassword(password1);
            List<String> list = forgotPasswordService.selectBsUserid(email);
            if (list==null){
                state.setState(false);
                return state;
            }
            Integer id = Integer.valueOf(list.get(0));
            String phone = list.get(1);
            bsUser.setId(id);
            if(phone.equals(phone1)){
                if(forgotPasswordService.ForgotPassword(bsUser)){
                    state.setState(true);
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
        state.setState(false);
        return state;

    }
}
