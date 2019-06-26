package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsShoppingCart;

public interface AddService {
    public boolean addCart(BsShoppingCart bsShoppingCart );
    public BsShoppingCart selectShopping(BsShoppingCart bsShoppingCart);
    public boolean updateShopping(BsShoppingCart bsShoppingCart);
}