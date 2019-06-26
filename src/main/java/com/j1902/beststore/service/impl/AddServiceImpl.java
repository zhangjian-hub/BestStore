package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.BsShoppingCartMapper;
import com.j1902.beststore.pojo.BsItemExample;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsShoppingCartExample;
import com.j1902.beststore.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddServiceImpl implements AddService {
    @Autowired
    private BsShoppingCartMapper bsShoppingCartMapper;


    @Override
    public boolean addCart(BsShoppingCart bsShoppingCart1) {
        int insert = bsShoppingCartMapper.insert(bsShoppingCart1);
        return insert>0;
    }

    @Override
    public BsShoppingCart selectShopping( BsShoppingCart bsShoppingCart) {
        BsShoppingCartExample bsShoppingCartExample =new BsShoppingCartExample();
        BsShoppingCartExample.Criteria or = bsShoppingCartExample.or();
        or.andItemIdEqualTo(bsShoppingCart.getItemId());
        List<BsShoppingCart> bsShoppingCarts = bsShoppingCartMapper.selectByExample(bsShoppingCartExample);
        if (bsShoppingCarts.size()<0){
            return null;
        }
        return bsShoppingCarts.get(0) ;
    }

    @Override
    public boolean updateShopping(BsShoppingCart bsShoppingCart1) {
        int i = bsShoppingCartMapper.updateByPrimaryKeySelective(bsShoppingCart1);
        return i > 0 ;
    }
}
