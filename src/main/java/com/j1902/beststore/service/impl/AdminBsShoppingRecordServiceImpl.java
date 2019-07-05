package com.j1902.beststore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.mapper.BsShoppingRecordMapper;
import com.j1902.beststore.pojo.BsShoppingRecord;
import com.j1902.beststore.service.AdminBsShoppingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BsShoppingRecord> bsShoppingRecords = shoppingRecordMapper.selectByExample(null);
        PageInfo<BsShoppingRecord> pageInfo = new PageInfo<>(bsShoppingRecords);
        return pageInfo;
    }
}
