package com.j1902.beststore.service.impl;


import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.ItemServiceLjy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//
@Service
public class ItemServiceImplLjy implements ItemServiceLjy {
    @Autowired
    private BsItemMapper bsItemMapper;

    @Override
    public List<BsItem> selectAllGroupByName(BsItem bsItem) {
        return  bsItemMapper.selectAllGroupByName(bsItem);

    }

    @Override
    public List<BsItem> selectAll() {
//        BsUserExample userExample = new BsUserExample();
//        BsUserExample.Criteria criteria = userExample.or();
//        criteria.andEmailEqualTo(null);

        return bsItemMapper.selectAll();
    }

}
