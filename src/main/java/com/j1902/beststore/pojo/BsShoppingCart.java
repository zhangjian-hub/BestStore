package com.j1902.beststore.pojo;

public class BsShoppingCart {
    private Integer id;

    private Integer userId;

    private Integer itemId;

    private Integer number;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BsShoppingCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", number=" + number +
                '}';
    }
}