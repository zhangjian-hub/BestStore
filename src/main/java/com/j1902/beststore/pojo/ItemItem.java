package com.j1902.beststore.pojo;

public class ItemItem {
    private Integer id;

    private Integer itemPropertyId;

    private Integer itemSizeId;

    private Integer itemColorId;

    private Integer inventory;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemPropertyId() {
        return itemPropertyId;
    }

    public void setItemPropertyId(Integer itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }

    public Integer getItemSizeId() {
        return itemSizeId;
    }

    public void setItemSizeId(Integer itemSizeId) {
        this.itemSizeId = itemSizeId;
    }

    public Integer getItemColorId() {
        return itemColorId;
    }

    public void setItemColorId(Integer itemColorId) {
        this.itemColorId = itemColorId;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}