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
        return users.get(0).getPassword().equals(MD5Util.encrypt(MD5Util.encrypt(bsUser.getPassword())));
    }

    @Override
    public boolean register(BsUser bsUser) {
        try {
            bsUser.setPassword(MD5Util.encrypt(MD5Util.encrypt(bsUser.getPassword())));
            bsUserMapper.insert(bsUser);
            return true ;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean verity(String email) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria1 = userExample.or();
        criteria1.andEmailEqualTo(email);
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        return bsUsers != null && bsUsers.size() > 0;
    }


}
