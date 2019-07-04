package com.j1902.beststore.controller;

import com.j1902.beststore.modle.State;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.BsUserService;
import com.j1902.beststore.service.EmailUsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class EmailUsController {
     @Autowired
    private EmailUsService emailUsService;
    @Autowired
     private BsUserService bsUserService;


    @RequestMapping("/toEmailUs")
    @ResponseBody
    public State forgotPassword(HttpServletRequest req, HttpSession session) {
        State state = new State();
        String userEmail = req.getParameter("userEmail");
       if (!bsUserService.verityEmail(userEmail)){
           state.setState(false);
           return state;
       }
        String content = req.getParameter("content");

        Date createTime = new Date();

        BsEmail bsEmail = new BsEmail();
        bsEmail.setUserEmail(userEmail);
        bsEmail.setContent(content);
        bsEmail.setCreateTime(createTime);


        if(userEmail!=null&&!"".equals(userEmail) && content!=null&&!"".equals(content)){
            emailUsService.emailUs(bsEmail);
                state.setState(true);
                return state;

        }
            state.setState(false);
            return state;
    }

}
