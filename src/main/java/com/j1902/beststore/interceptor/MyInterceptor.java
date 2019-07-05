package com.j1902.beststore.interceptor;

import com.j1902.beststore.pojo.BsUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-30 8:47
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        BsUser user = (BsUser) session.getAttribute("USER_INFO");
        if (user != null) {
            if (user.getEmail() != null) {
                if (user.getEmail().equals("15927147398@qq.com")) {
                    return true;
                }
            }
        }
        response.sendRedirect("/toErrorIndex");
        return false;
    }
}
