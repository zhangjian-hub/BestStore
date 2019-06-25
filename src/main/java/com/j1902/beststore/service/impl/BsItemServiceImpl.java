package com.j1902.beststore.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.mapper.BsItemMapper;
import com.j1902.beststore.mapper.BsShoppingCartMapper;
import com.j1902.beststore.mapper.BsShoppingRecordMapper;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsShoppingCartExample;
import com.j1902.beststore.pojo.BsShoppingRecord;


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
    @Autowired
    private BsShoppingRecordMapper bsShoppingRecordMapper;

    //查询用户购物车
    @Override
    public List<BsShoppingCart> getBsShoppingCart(Integer id) {
        BsShoppingCartExample bsShoppingCartExample = new BsShoppingCartExample();
        BsShoppingCartExample.Criteria or = bsShoppingCartExample.or();
        or.andUserIdEqualTo(id);
        List<BsShoppingCart> bsShoppingCarts = bsShoppingCartMapper.selectByExample(bsShoppingCartExample);
        return bsShoppingCarts;
    }

    //查询商品信息
    @Override
    public BsItem getItem(Integer id) {
        BsItem bsItem = bsItemMapper.selectByPrimaryKey(id);
        return bsItem;
    }

    //查询购物车分页
    @Override
    public PageInfo<BsShoppingCart> pageBsShoppingCart(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BsShoppingCartExample bsShoppingCartExample = new BsShoppingCartExample();
        BsShoppingCartExample.Criteria or = bsShoppingCartExample.or();
        or.andUserIdEqualTo(id);
        List<BsShoppingCart> bsShoppingCarts = bsShoppingCartMapper.selectByExample(bsShoppingCartExample);
        int size = bsShoppingCarts.size();
        PageInfo<BsShoppingCart> pageInfo = new PageInfo<>(bsShoppingCarts);
        int pageSize1 = pageInfo.getPageSize();
        return pageInfo;
    }

    //    修改购物车商品数量
    @Override
    public boolean updateItemNumber(BsShoppingCart bsShoppingCart) {
        int i = bsShoppingCartMapper.updateByPrimaryKeySelective(bsShoppingCart);
        return i > 0 ? true : false;
    }

    //    删除购物车
    @Override
    public boolean removeShoppingCart(Integer id) {
        int i = bsShoppingCartMapper.deleteByPrimaryKey(id);
        return i > 0 ? true : false;
    }

    //    根据ID查询购物车
    @Override
    public BsShoppingCart getBsShoppingCartById(Integer id) {
        return bsShoppingCartMapper.selectByPrimaryKey(id);
    }

    //    添加购物记录
    @Override
    public boolean addBsShoppingRecord(BsShoppingRecord bsShoppingRecord) {
        int i = bsShoppingRecordMapper.insertSelective(bsShoppingRecord);
        return i > 0 ? true : false;
    }
}

