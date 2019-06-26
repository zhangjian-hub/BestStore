package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsItem;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:04
 */
public interface AdminBsItemService {
    public List<BsItem> getAllItems();

    public void addItem(BsItem item);

    public void setItem(BsItem item);

    public void removeItem(Integer id);
}
