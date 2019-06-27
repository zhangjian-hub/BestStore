package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsItemExample;
import com.j1902.beststore.service.BsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsItemServiceIplm implements BsItemService {
    @Autowired
    public BsItemMapper bsItemMapper;
    @Override
    public List<BsItem> toCommodityDetails(BsItem bsItem) {
        BsItemExample bsItemExample =new BsItemExample();
        BsItemExample.Criteria or = bsItemExample.or();
        or.andNameEqualTo(bsItem.getName());
        List<BsItem> bsItems = bsItemMapper.selectByExample(bsItemExample);
        if (bsItems==null||bsItems.size()==0){
            return null;
        }
        return bsItems;
    }

    @Override
    public BsItem toCommodityDetail(BsItem bsItem) {
        System.out.println("bsItemsdfsdg = " + bsItem);
        BsItemExample bsItemExample =new BsItemExample();
        BsItemExample.Criteria or = bsItemExample.or();
        or.andNameEqualTo(bsItem.getName());
        or.andSizeEqualTo(bsItem.getSize());
        or.andColorEqualTo(bsItem.getColor());
        List<BsItem> bsItems = bsItemMapper.selectByExample(bsItemExample);
        if (bsItems==null || bsItems.size()==0){
            return null;
        }
        System.out.println(bsItems.get(0));
        return bsItems.get(0);
    }
}
