package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsEmail;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-25 14:06
 */
public interface AdminBsEmailService {
    public List<BsEmail> getAllEmails();

    public BsEmail selectById(Integer id);
}
