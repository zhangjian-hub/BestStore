package com.j1902.beststore.service;


import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsShoppingRecord;

import java.util.List;

public interface BsShoppingCartItemService {

    public List<BsShoppingCart> getBsShoppingCart(Integer id);

    public BsItem getItem(Integer id);

    public PageInfo<BsShoppingCart> pageBsShoppingCart(Integer id, Integer pageNum, Integer pageSize);

    public boolean updateItemNumber(BsShoppingCart bsShoppingCart);

    public boolean removeShoppingCart(Integer id);

    public BsShoppingCart getBsShoppingCartById(Integer id);

    public boolean addBsShoppingRecord(BsShoppingRecord bsShoppingRecord);

    public boolean setNumber(BsItem item);

}