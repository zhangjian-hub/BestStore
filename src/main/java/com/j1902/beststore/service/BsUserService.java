package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsUser;

public interface BsUserService {
    public boolean login(BsUser bsUser);

    public boolean isExistBsUser(BsUser bsUser);

    public void addBsUser(BsUser bsUser);
}
