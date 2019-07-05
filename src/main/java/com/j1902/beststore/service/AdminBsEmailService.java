package com.j1902.beststore.service;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsEmail;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-25 14:06
 */
public interface AdminBsEmailService {
    public PageInfo<BsEmail> getAllEmails(int pageNum);

    public BsEmail selectById(Integer id);

    public int getCountOfAllEmails();

    public void removeEmail(Integer id);
}
