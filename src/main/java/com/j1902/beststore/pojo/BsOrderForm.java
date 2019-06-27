package com.j1902.beststore.pojo;

import java.util.Date;

public class BsOrderForm {
    private Integer id;

    private String orderId;

    private Integer itemId;

    private Integer userId;

    private Date createTime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "BsOrderForm{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", state='" + state + '\'' +
                '}';
    }
}