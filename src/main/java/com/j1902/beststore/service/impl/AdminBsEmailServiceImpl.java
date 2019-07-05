package com.j1902.beststore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<BsEmail> getAllEmails(int pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<BsEmail> bsEmails = emailMapper.selectByExample(null);
        for (BsEmail bsEmail : bsEmails) {
            bsEmail.setContent(emailMapper.selectByPrimaryKey(bsEmail.getId()).getContent());
        }
        PageInfo<BsEmail> pageInfo = new PageInfo<>(bsEmails);
        return pageInfo;
    }

    @Override
    public BsEmail selectById(Integer id) {

        return emailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getCountOfAllEmails() {
        return emailMapper.selectByExample(null).size();
    }

    @Override
    public void removeEmail(Integer id) {
        emailMapper.deleteByPrimaryKey(id);
    }
}
