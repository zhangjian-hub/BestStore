package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsUserMapper;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.pojo.BsUserExample;
import com.j1902.beststore.service.ForgotPasswordServiceLjy;
import com.j1902.beststore.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForgotPasswordServiceImplLjy implements ForgotPasswordServiceLjy {

    @Autowired
    private BsUserMapper bsUserMapper;

    private MD5Util md5Util;

    @Override
    public List<String> selectBsUserid(String email) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(email);
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        if (bsUsers.size()>0){
            Integer id = bsUsers.get(0).getId();
            String phone = bsUsers.get(0).getPhone();
            List<String> list = new ArrayList<>();
            list.add(0, id + "");
            list.add(1, phone);
            return list;
        }else {
            return null;
        }

    }

    @Override
    public boolean ForgotPassword(BsUser bsUser) {
        String password = md5Util.encrypt(md5Util.encrypt(bsUser.getPassword()));
        bsUser.setPassword(password);
        return bsUserMapper.updateByPrimaryKeySelective(bsUser);
    }
}
