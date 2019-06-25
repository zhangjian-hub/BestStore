package com.j1902.beststore.modle;

import com.j1902.beststore.pojo.BsItem;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-24 13:00
 */
public class UpdateItemsInfo {
    private List<Integer> ids;
    private List<BsItem> items;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<BsItem> getItems() {
        return items;
    }

    public void setItems(List<BsItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "UpdateItemsInfo{" +
                "ids=" + ids +
                ", items=" + items +
                '}';
    }
}
