package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsUserMapper;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.pojo.BsUserExample;
import com.j1902.beststore.service.BsUserService;
import com.j1902.beststore.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsUserServiceImpl implements BsUserService {

    @Autowired
    private BsUserMapper bsUserMapper;

    @Override
    public boolean login(BsUser bsUser) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(bsUser.getEmail());
        List<BsUser> users = bsUserMapper.selectByExample(userExample);
        if (users == null || users.size() == 0) {
            return false;
        }
        return users.get(0).getPassword().equals(bsUser.getPassword());
    }

    @Override
    public boolean isExistBsUser(BsUser bsUser) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria1 = userExample.or();
        criteria1.andEmailEqualTo(bsUser.getEmail());
        BsUserExample.Criteria criteria2 = userExample.or();
        criteria2.andPhoneEqualTo(bsUser.getPhone());
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        return bsUsers != null && bsUsers.size() > 0;
    }

    @Override
    public void addBsUser(BsUser bsUser) {
        bsUser.setPassword(MD5Util.encrypt(MD5Util.encrypt(bsUser.getPassword())));
        bsUserMapper.insert(bsUser);
    }
}
