package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsUser;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-26 18:55
 */
public interface AdminBsUserService {

    public int getCountOfBsUsers();

    public void setBsUSer(BsUser uSer);
}
