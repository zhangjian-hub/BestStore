package com.j1902.beststore.controller;

import com.j1902.beststore.modle.State;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.EmailUsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class EmailUsController {
     @Autowired
    private EmailUsService emailUsService;


    @RequestMapping("/toEmailUs")
    @ResponseBody
    public State forgotPassword(HttpServletRequest req) {
        String userEmail = req.getParameter("userEmail");
        System.out.println("userEmail = " + userEmail);
        String content = req.getParameter("content");
        System.out.println("content = " + content);

        Date createTime = new Date();
        System.out.println("createTime = " + createTime);

        BsEmail bsEmail = new BsEmail();
        bsEmail.setUserEmail(userEmail);
        bsEmail.setContent(content);
        bsEmail.setCreateTime(createTime);

        State state = new State();
        if(userEmail!=null&&!"".equals(userEmail) && content!=null&&!"".equals(content)){
            System.out.println("xxx = " + bsEmail);
            System.out.println("emailUsService.emailUs(bsEmail) = " + emailUsService.emailUs(bsEmail));
            emailUsService.emailUs(bsEmail);
                state.setState(true);
                System.out.println("state1 = " + state);
                return state;

        }
            state.setState(false);
        System.out.println("state2 = " + state);
            return state;
    }
}
