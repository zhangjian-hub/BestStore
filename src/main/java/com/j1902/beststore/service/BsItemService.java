package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;

import java.util.List;

public interface BsItemService {

    public List<BsShoppingCart> getBsShoppingCart(Integer id);

    public BsItem getItem(Integer id);
}
