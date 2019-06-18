package com.j1902.beststore.pojo;

import java.util.Date;

public class ShoppingRecord {
    private Integer id;

    private Integer userId;

    private Integer itemId;

    private Integer itemPropertyId;

    private Date shoppingTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemPropertyId() {
        return itemPropertyId;
    }

    public void setItemPropertyId(Integer itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }

    public Date getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(Date shoppingTime) {
        this.shoppingTime = shoppingTime;
    }
}