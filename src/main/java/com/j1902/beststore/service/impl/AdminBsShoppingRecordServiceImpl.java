package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsShoppingRecordMapper;
import com.j1902.beststore.service.AdminBsShoppingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-26 19:03
 */
@Service
public class AdminBsShoppingRecordServiceImpl implements AdminBsShoppingRecordService {
    @Autowired
    private BsShoppingRecordMapper shoppingRecordMapper;

    @Override
    public int getCountOfAll() {
        return shoppingRecordMapper.selectByExample(null).size();
    }
}
