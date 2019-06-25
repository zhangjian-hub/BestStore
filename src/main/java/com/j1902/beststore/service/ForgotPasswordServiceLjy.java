package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsUser;

import java.util.List;


public interface ForgotPasswordServiceLjy {
    public List<String> selectBsUserid(String email);

    public boolean ForgotPassword(BsUser bsUser);
}
