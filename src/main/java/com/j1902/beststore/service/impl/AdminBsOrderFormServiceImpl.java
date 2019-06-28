package com.j1902.beststore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.mapper.BsOrderFormMapper;
import com.j1902.beststore.pojo.BsOrderForm;
import com.j1902.beststore.service.AdminBsOrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-27 8:39
 */

@Service
public class AdminBsOrderFormServiceImpl implements AdminBsOrderFormService {

    @Autowired
    private BsOrderFormMapper orderFormMapper;
    @Override
    public PageInfo getAllOrderForms(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BsOrderForm> pageInfo = new PageInfo<>(orderFormMapper.selectByExample(null));
        return pageInfo;
    }

    @Override
    public boolean addOrderForms(BsOrderForm orderForm) {
        int insert = orderFormMapper.insert(orderForm);
        return insert > 0;
    }

    @Override
    public void setOrderFormState(BsOrderForm orderForm) {
        orderFormMapper.updateByPrimaryKeySelective(orderForm);
    }

    @Override
    public void removeItem(Integer id) {
        orderFormMapper.deleteByPrimaryKey(id);
    }
}
