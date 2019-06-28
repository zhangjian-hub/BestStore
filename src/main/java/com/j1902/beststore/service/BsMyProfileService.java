package com.j1902.beststore.service;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsOrderForm;
import com.j1902.beststore.pojo.BsShoppingRecord;

public interface BsMyProfileService {
    public PageInfo<BsOrderForm> pageBsOrderForm(Integer id, Integer pageNum, Integer pageSize);

    public BsItem getItem(Integer id);

    public BsOrderForm getBsOrderForm(Integer id);

    public boolean addBsShoppingRecord(BsShoppingRecord bsShoppingRecord);

    public boolean removeBsOrderForm(Integer id);

    public PageInfo<BsShoppingRecord> pageShoppingRecord(Integer id, Integer pageNum, Integer pageSize);
}
