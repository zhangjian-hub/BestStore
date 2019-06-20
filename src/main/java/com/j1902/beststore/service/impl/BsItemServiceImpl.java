package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.mapper.BsShoppingCartMapper;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsShoppingCartExample;
import com.j1902.beststore.service.BsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsItemServiceImpl implements BsItemService {
    @Autowired
    private BsShoppingCartMapper bsShoppingCartMapper;
    @Autowired
    private BsItemMapper bsItemMapper;
    @Override
    public List<BsShoppingCart> getBsShoppingCart(Integer id) {
        BsShoppingCartExample bsShoppingCartExample = new BsShoppingCartExample();
        BsShoppingCartExample.Criteria or = bsShoppingCartExample.or();
        or.andUserIdEqualTo(id);
        List<BsShoppingCart> bsShoppingCarts = bsShoppingCartMapper.selectByExample(bsShoppingCartExample);
        return bsShoppingCarts;
    }

    @Override
    public BsItem getItem(Integer id) {
        BsItem bsItem = bsItemMapper.selectByPrimaryKey(1);
        return bsItem;
    }
}
