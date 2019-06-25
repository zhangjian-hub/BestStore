package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.AdminBsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:08
 */

@Service
public class AdminBsItemServiceImpl implements AdminBsItemService {
    @Autowired
    private BsItemMapper itemMapper;

    @Override
    public List<BsItem> getAllItems() {
        return itemMapper.selectByExample(null);
    }

    @Override
    public void addItem(BsItem item) {
        itemMapper.insert(item);
    }

    @Override
    public void setItem(BsItem item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public void removeItem(Integer id) {
        itemMapper.deleteByPrimaryKey(id);
    }
}
