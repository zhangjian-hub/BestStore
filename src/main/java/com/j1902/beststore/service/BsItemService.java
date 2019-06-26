package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsItem;

import java.util.List;

public interface BsItemService {
    public List<BsItem> toCommodityDetails(BsItem bsItem);
    public BsItem toCommodityDetail(BsItem bsItem);

}
