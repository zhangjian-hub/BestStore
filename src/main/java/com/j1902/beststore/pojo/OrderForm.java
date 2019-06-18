package com.j1902.beststore.pojo;

public class OrderForm {
    private Integer id;

    private Integer orderNumber;

    private Integer userId;

    private Integer itemId;

    private Integer itemPropertyId;

    private Integer stateId;

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

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}