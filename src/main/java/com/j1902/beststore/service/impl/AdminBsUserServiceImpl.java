package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsUserMapper;
import com.j1902.beststore.service.AdminBsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-26 18:56
 */
@Service
public class AdminBsUserServiceImpl implements AdminBsUserService {

    @Autowired
    private BsUserMapper userMapper;
    @Override
    public int getCountOfBsUsers() {
        return userMapper.selectByExample(null).size();
    }
}
