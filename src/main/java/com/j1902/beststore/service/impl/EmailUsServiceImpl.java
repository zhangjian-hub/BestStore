package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsEmailMapper;
import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.service.EmailUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailUsServiceImpl implements EmailUsService {
    @Autowired
    private BsEmailMapper bsEmailMapper;
    @Override
    public boolean emailUs(BsEmail bsEmail) {
        int insert = bsEmailMapper.insert(bsEmail);
        System.out.println("insert = " + insert);
        if(insert ==1){
            return true;
        }else {
            return false;
        }
    }
}
