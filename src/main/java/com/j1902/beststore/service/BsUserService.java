package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsUser;

import javax.servlet.http.HttpServletRequest;

public interface BsUserService {
    public BsUser login(BsUser bsUser, HttpServletRequest req);
    public boolean register(BsUser bsUser);
    public boolean  verityEmail(String email);
    public boolean  verityPhone(String phone);
}
