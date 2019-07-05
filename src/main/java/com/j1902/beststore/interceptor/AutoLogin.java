package com.j1902.beststore.interceptor;

import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.utils.JsonUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

public class AutoLogin implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        BsUser bsUser = new BsUser();
        BsUser user_info = (BsUser) session.getAttribute("USER_INFO");
        String info = (String) session.getAttribute("info");
        if (user_info == null && info == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if ("loginInfo".equals(cookie.getName())) {
                        String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        bsUser = JsonUtils.jsonToPojo(decode, BsUser.class);
                        session.setAttribute("USER_INFO", bsUser);
                    }
                }
            }
        }
        return true;
    }
}
