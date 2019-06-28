package com.j1902.beststore.service.impl;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.j1902.beststore.mapper.BsUserMapper;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.pojo.BsUserExample;
import com.j1902.beststore.service.BsUserService;
import com.j1902.beststore.utils.MD5Util;
import com.j1902.beststore.utils.UseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class BsUserServiceImpl implements BsUserService {

    @Autowired
    private BsUserMapper bsUserMapper;

    @Override
    public BsUser login(BsUser bsUser, HttpServletRequest req) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(bsUser.getEmail());
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        if (bsUsers == null || bsUsers.size() == 0) {
            return null;
        }
       if(bsUsers.get(0).getPassword().equals(MD5Util.encrypt(MD5Util.encrypt(bsUser.getPassword())))){
           bsUsers.get(0).setLastLogin(bsUsers.get(0).getNowLogin());
           bsUsers.get(0).setNowLogin(new Date());
           bsUsers.get(0).setLastIp(bsUsers.get(0).getNowIp());
           bsUsers.get(0).setNowIp(UseUtil.getIpAddress(req));
           bsUserMapper.updateByPrimaryKey(bsUsers.get(0));
           return bsUsers.get(0);
       }else{
           return null;
       }
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
    public boolean verityEmail(String email) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria1 = userExample.or();
        criteria1.andEmailEqualTo(email);
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        System.out.println(bsUsers != null && bsUsers.size() > 0);
        return bsUsers != null && bsUsers.size() > 0;
    }
    @Override
    public boolean verityPhone(String phone) {
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria1 = userExample.or();
        criteria1.andPhoneEqualTo(phone);
        List<BsUser> bsUsers = bsUserMapper.selectByExample(userExample);
        return bsUsers != null && bsUsers.size() > 0;
    }

}
