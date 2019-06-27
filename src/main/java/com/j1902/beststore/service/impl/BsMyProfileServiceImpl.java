package com.j1902.beststore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.mapper.BsOrderFormMapper;
import com.j1902.beststore.mapper.BsShoppingRecordMapper;
import com.j1902.beststore.pojo.*;
import com.j1902.beststore.service.BsMyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsMyProfileServiceImpl implements BsMyProfileService {
    @Autowired
    private BsOrderFormMapper bsOrderFormMapper;
    @Autowired
    private BsItemMapper bsItemMapper;
    @Autowired
    private BsShoppingRecordMapper bsShoppingRecordMapper;

    //    查询订单表的分页
    @Override
    public PageInfo<BsOrderForm> pageBsOrderForm(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BsOrderFormExample bsOrderFormExample = new BsOrderFormExample();
        BsOrderFormExample.Criteria or = bsOrderFormExample.or();
        or.andUserIdEqualTo(id);
        List<BsOrderForm> bsOrderForms = bsOrderFormMapper.selectByExample(bsOrderFormExample);
        PageInfo<BsOrderForm> pageInfo = new PageInfo<>(bsOrderForms);
        return pageInfo;
    }

    //    查询商品信息
    @Override
    public BsItem getItem(Integer id) {
        return bsItemMapper.selectByPrimaryKey(id);
    }


    //    查询订单表
    @Override
    public BsOrderForm getBsOrderForm(Integer id) {
        return bsOrderFormMapper.selectByPrimaryKey(id);
    }

    //    插入购物记录表
    @Override
    public boolean addBsShoppingRecord(BsShoppingRecord bsShoppingRecord) {
        int i = bsShoppingRecordMapper.insertSelective(bsShoppingRecord);
        return i > 0;
    }

    //    删除订单表
    @Override
    public boolean removeBsOrderForm(Integer id) {
        int i = bsOrderFormMapper.deleteByPrimaryKey(id);
        return i > 0;
    }

    //    记录表的分页
    @Override
    public PageInfo<BsShoppingRecord> pageShoppingRecord(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BsShoppingRecordExample bsShoppingRecordExample = new BsShoppingRecordExample();
        BsShoppingRecordExample.Criteria or = bsShoppingRecordExample.or();
        or.andUserIdEqualTo(id);
        List<BsShoppingRecord> bsShoppingRecords = bsShoppingRecordMapper.selectByExample(bsShoppingRecordExample);
        PageInfo<BsShoppingRecord> pageInfo = new PageInfo<>(bsShoppingRecords);
        return pageInfo;
    }
}