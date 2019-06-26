package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsEmailMapper;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.AdminBsEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-25 14:07
 */

@Service
public class AdminBsEmailServiceImpl implements AdminBsEmailService {

    @Autowired
    private BsEmailMapper emailMapper;

    @Override
    public List<BsEmail> getAllEmails() {
        List<BsEmail> bsEmails = emailMapper.selectByExample(null);
        System.out.println("bsEmails = " + bsEmails);
        return bsEmails;
    }

    @Override
    public BsEmail selectById(Integer id) {
        BsEmail bsEmail = emailMapper.selectByPrimaryKey(id);
        System.out.println("bsEmail = " + bsEmail);
        return bsEmail;
    }
}
