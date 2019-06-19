package com.j1902.beststore.pojo;

public class OrderForm {
    private Integer id;

    private Integer orderNumber;

    private Integer userId;

    private Integer itemId;

    private Integer itemPropertyId;

    private Integer orderStateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }
}