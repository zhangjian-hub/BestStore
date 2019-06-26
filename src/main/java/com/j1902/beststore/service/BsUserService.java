package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsUser;

public interface BsUserService {
    public boolean login(BsUser bsUser);
    public boolean register(BsUser bsUser);
    public boolean  verity(String email);
}
