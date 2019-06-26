package com.j1902.beststore.service;

import com.j1902.beststore.pojo.BsItem;
import java.util.List;

public interface ItemServiceLjy {


    public List<BsItem> selectAllGroupByName(BsItem bsItem);

    public  List<BsItem> selectAll();
}
